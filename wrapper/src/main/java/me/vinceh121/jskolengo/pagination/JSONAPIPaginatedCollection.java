package me.vinceh121.jskolengo.pagination;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.models.errors.Error;

public class JSONAPIPaginatedCollection<T> implements Iterable<T> {
	private final PageFetcher<JSONAPIDocument<List<T>>> fetcher;
	private int batchSize = 10;

	public JSONAPIPaginatedCollection(PageFetcher<JSONAPIDocument<List<T>>> fetcher) {
		this.fetcher = fetcher;
	}

	@Override
	public Iterator<T> iterator() {
		return new PaginatedIterator();
	}

	public Stream<T> stream() {
		Iterator<T> iter = this.iterator();
		// XXX This usage doesn't respect the hasNext and next contracts since we don't
		// check ordering.
		// Is this actually liable to cause problems?
		T seed = ((JSONAPIPaginatedCollection<T>.PaginatedIterator) iter).peek();
		return Stream.iterate(seed, e -> iter.hasNext(), e -> iter.next());
	}

	private class PaginatedIterator implements Iterator<T> {
		private JSONAPIDocument<List<T>> currentCollection;
		/**
		 * Index within currentCollection
		 */
		private int currentLocalIndex;
		private int currentPage;

		public PaginatedIterator() {
			try {
				this.currentCollection = fetcher.fetchPage(batchSize, 0);
				this.checkError();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private void checkError() {
			List<? extends Error> errs = (List<? extends Error>) this.currentCollection.getErrors();
			if (errs != null && errs.size() != 0) {
				throw new RuntimeException(errs.toString());
			}
		}

		@Override
		public boolean hasNext() {
			return this.currentLocalIndex < this.currentCollection.get().size()
					|| this.currentCollection.getLinks().getNext() != null;
		}

		T peek() {
			T e = this.next();
			this.currentLocalIndex--;
			return e;
		}

		@Override
		public T next() {
			try {
				if (currentLocalIndex < currentCollection.get().size()) {
					T next = currentCollection.get().get(currentLocalIndex);
					currentLocalIndex++;
					return next;
				} else {
					currentPage++;
					currentCollection = fetcher.fetchPage(batchSize, currentPage * batchSize);
					this.checkError();
					currentLocalIndex = 1; // prevent duplicates
					return currentCollection.get().get(0);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public int getBatchSize() {
		return batchSize;
	}

	public JSONAPIPaginatedCollection<T> setBatchSize(int batchSize) {
		this.batchSize = batchSize;
		return this;
	}
}
