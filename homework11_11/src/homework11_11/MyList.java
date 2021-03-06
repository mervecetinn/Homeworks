package homework11_11;

public class MyList {
	String[] items;

	public MyList() {
		items = new String[0];
	}

	public void add(String item) {
		String[] tempList = items;
		items = new String[items.length + 1];
		for (int i = 0; i < tempList.length; i++) {
			items[i] = tempList[i];
		}
		items[items.length - 1] = item;

	}

	public void remove(int index) {
		if (index < 0 || index >= items.length) {
			System.out.println("False Index!");
		} else {
			String[] tempList = items;
			items = new String[items.length - 1];

			for (int i = 0; i < items.length; i++) {
				if (i == index) {
					items[i] = tempList[i + 1];
				} else if (i > index) {
					items[i] = tempList[i + 1];
				} else {
					items[i] = tempList[i];
				}
			}
		}
	}

	public void remove(String removedItem) {

		int removedItemFirstIndex = getFirstIndex(items, removedItem);
		if (removedItemFirstIndex == -1) {
			System.out.println("There is not such item!");
		} else {
			String[] tempList = items;
			items = new String[items.length - 1];

			for (int i = 0; i < items.length; i++) {
				if (i == removedItemFirstIndex) {
					items[i] = tempList[i + 1];
				} else if (i > removedItemFirstIndex) {
					items[i] = tempList[i + 1];
				} else {
					items[i] = tempList[i];
				}
			}
		}
	}

	public void removeAll(String removedItem) {

		int removedItemCount = getCount(items, removedItem);
		if (removedItemCount == 0) {
			System.out.println("There is not such item!");
		} else {
			String[] tempList = items;
			items = new String[items.length - removedItemCount];

			int count = 0;
			for (int i = 0; i < tempList.length; i++) {
				if (tempList[i] != removedItem) {
					items[count] = tempList[i];
					count = count + 1;
				} else {
					continue;
				}
			}
		}
	}

	public boolean contains(String searchingItem) {
		for (int i = 0; i < items.length; i++) {
			if (searchingItem == items[i]) {
				return true;
			}
		}
		return false;
	}

	public void list() {
		int i = 1;
		for (String listItem : getItems()) {
			System.out.println(i + ". " + listItem);
			i++;
		}
	}

	public String[] getItems() {
		return items;
	}

	private int getCount(String items[], String searchingItem) {
		int count = 0;
		for (Object item : items) {
			if (item == searchingItem) {
				count++;
			}
		}
		return count;
	}

	private int getFirstIndex(String items[], String searchingItem) {
		int index = -1;
		for (int i = 0; i < items.length; i++) {
			if (searchingItem == items[i]) {
				index = i;
				break;

			}
		}
		return index;
	}

	public int length() {
		return items.length;
	}

}
