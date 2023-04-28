package me.vinceh121.jskolengo.pagination;

import java.io.IOException;

@FunctionalInterface
public interface PageFetcher<T> {
	T fetchPage(int limit, int offset) throws IOException;
}
