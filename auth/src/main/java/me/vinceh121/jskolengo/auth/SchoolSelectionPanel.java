package me.vinceh121.jskolengo.auth;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;

import me.vinceh121.jskolengo.JSkolengoAnonymous;
import me.vinceh121.jskolengo.entities.School;
import me.vinceh121.jskolengo.pagination.JSONAPIPaginatedCollection;

public class SchoolSelectionPanel extends JPanel {
	private static final long serialVersionUID = -1159248426270546927L;
	private final JSkolengoAnonymous skolengo;
	private final JTextField txtSearch = new JTextField();
	private final JList<School> lstSchools = new JList<>();

	public SchoolSelectionPanel(JSkolengoAnonymous skolengo) {
		this.skolengo = skolengo;

		this.setLayout(new BorderLayout(5, 5));

		this.add(this.txtSearch, BorderLayout.NORTH);
		this.add(new JScrollPane(this.lstSchools), BorderLayout.CENTER);

		this.lstSchools.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.txtSearch.addActionListener(e -> {
			SchoolsFetcher fetch = new SchoolsFetcher(this.txtSearch.getText());
			fetch.run();
		});

		this.lstSchools.setCellRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

				School sch = (School) value;
				this.setText(sch.getName() + ", " + sch.getCity());

				this.setToolTipText("<html>" + sch.toString().replaceAll(", ", "<br>") + "</html>");

				return this;
			}
		});
	}

	public School getSelectedSchool() {
		return this.lstSchools.getSelectedValue();
	}

	private class SchoolsFetcher extends SwingWorker<List<School>, Void> {
		private final String text;

		public SchoolsFetcher(String text) {
			this.text = text;
		}

		@Override
		protected List<School> doInBackground() throws Exception {
			txtSearch.setEnabled(false);
			lstSchools.setEnabled(false);

			Vector<School> schls = new Vector<>();

			try {
				JSONAPIPaginatedCollection<School> res = skolengo.searchSchools(this.text);
				res.forEach(schls::add);

				if (schls.size() == 0) {
					JOptionPane.showMessageDialog(null, "Got 0 results");
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.toString());
			}

			txtSearch.setEnabled(true);
			lstSchools.setEnabled(true);
			lstSchools.setListData(schls);
			return schls;
		}
	}
}
