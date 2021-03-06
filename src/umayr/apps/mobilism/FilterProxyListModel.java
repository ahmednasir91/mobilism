package umayr.apps.mobilism;

import java.util.Vector;


import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.list.ListModel;

class FilterProxyListModel implements ListModel, DataChangedListener {
	private ListModel underlying;
	private Vector filter;
	private Vector listeners = new Vector();

	public FilterProxyListModel(ListModel underlying) {
		this.underlying = underlying;
		underlying.addDataChangedListener(this);
	}

	private int getFilterOffset(int index) {
		if (filter == null) {
			return index;
		}
		if (filter.size() > index) {
			return ((Integer) filter.elementAt(index)).intValue();
		}
		return -1;
	}

	private int getUnderlyingOffset(int index) {
		if (filter == null) {
			return index;
		}
		return filter.indexOf(new Integer(index));
	}

	public void filter(String str) {
		filter = new Vector();
		str = str.toUpperCase();

		for (int iter = 0; iter < underlying.getSize(); iter++) {
			String element = (String) underlying.getItemAt(iter);
			if (element.toUpperCase().indexOf(str) > -1) {
				filter.addElement(new Integer(iter));
			}
		}
		dataChanged(DataChangedListener.CHANGED, -1);
	}

	public Object getItemAt(int index) {
		return underlying.getItemAt(getFilterOffset(index));
	}

	public int getSize() {
		if (filter == null) {
			return underlying.getSize();
		}
		return filter.size();
	}

	public int getSelectedIndex() {
		return Math.max(0, getUnderlyingOffset(underlying.getSelectedIndex()));
	}

	public void setSelectedIndex(int index) {
		underlying.setSelectedIndex(getFilterOffset(index));
	}

	public void addDataChangedListener(DataChangedListener l) {
		listeners.addElement(l);
	}

	public void removeDataChangedListener(DataChangedListener l) {
		listeners.removeElement(l);
	}

	public void addItem(Object item) {
		underlying.addItem(item);
	}

	public void removeItem(int index) {
		underlying.removeItem(index);
	}

	public void dataChanged(int type, int index) {
		if (index > -1) {
			index = getUnderlyingOffset(index);
			if (index < 0) {
				return;
			}
		}
		for (int iter = 0; iter < listeners.size(); iter++) {

			((DataChangedListener) listeners.elementAt(iter)).dataChanged(type,
					index);
		}
	}

	public void addSelectionListener(SelectionListener arg0) {

		underlying.addSelectionListener(arg0);

	}

	public void removeSelectionListener(SelectionListener arg0) {

		underlying.removeSelectionListener(arg0);

	}
}