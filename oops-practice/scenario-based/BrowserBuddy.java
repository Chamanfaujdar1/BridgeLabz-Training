import java.util.Scanner;
import java.util.Stack;

class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

class BrowserHistory {
    private HistoryNode head;
    private HistoryNode tail;
    private HistoryNode current;

    public BrowserHistory() {
        head = tail = current = null;
    }

    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            if (current != tail) {
                HistoryNode temp = current.next;
                while (temp != null) {
                    HistoryNode nextTemp = temp.next;
                    temp.prev = null;
                    temp.next = null;
                    temp = nextTemp;
                }
                current.next = null;
                tail = current;
            }

            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
            current = newNode;
        }

        System.out.println("Visited: " + url);
    }

    public void back() {
        if (current == null) {
            System.out.println("No history available!");
            return;
        }
        if (current.prev == null) {
            System.out.println("Already at first page. Can't go back!");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    public void forward() {
        if (current == null) {
            System.out.println(" No history available!");
            return;
        }
        if (current.next == null) {
            System.out.println(" No forward page available!");
            return;
        }
        current = current.next;
        System.out.println(" Forward to: " + current.url);
    }

    public void showCurrent() {
        if (current == null) {
            System.out.println("Current Page: NONE");
        } else {
            System.out.println("Current Page: " + current.url);
        }
    }

    public void printHistory() {
        if (head == null) {
            System.out.println(" History is EMPTY!");
            return;
        }

        System.out.println("\n=== Tab History ===");
        HistoryNode temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println(temp.url + "  (CURRENT)");
            } else {
                System.out.println("   " + temp.url);
            }
            temp = temp.next;
        }
    }

    public String getCurrentUrl() {
        return (current == null) ? null : current.url;
    }

    public BrowserHistory deepCopy() {
        BrowserHistory copy = new BrowserHistory();
        HistoryNode temp = head;

        while (temp != null) {
            copy.visit(temp.url);
            temp = temp.next;
        }
        return copy;
    }

    public void clear() {
        HistoryNode temp = head;
        while (temp != null) {
            HistoryNode next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = next;
        }
        head = tail = current = null;
    }
}

class Tab {
    private static int tabCounter = 1;
    private int tabId;
    private BrowserHistory history;

    public Tab() {
        tabId = tabCounter++;
        history = new BrowserHistory();
    }

    public int getTabId() {
        return tabId;
    }

    public BrowserHistory getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return "Tab-" + tabId;
    }
}

class BrowserManager {
    private Tab activeTab;
    private Stack<Tab> closedTabs;

    public BrowserManager() {
        activeTab = new Tab();
        closedTabs = new Stack<>();
        System.out.println(" Browser Started with " + activeTab);
    }

    public void visitUrl(String url) {
        activeTab.getHistory().visit(url);
    }

    public void back() {
        activeTab.getHistory().back();
    }

    public void forward() {
        activeTab.getHistory().forward();
    }

    public void showCurrentPage() {
        System.out.print(activeTab + " -> ");
        activeTab.getHistory().showCurrent();
    }

    public void printActiveHistory() {
        System.out.println("\n Active Tab: " + activeTab);
        activeTab.getHistory().printHistory();
    }

    public void closeTab() {
        System.out.println(" Closing " + activeTab);

        Tab backupTab = new Tab();
        backupTab.getHistory().clear();
        backupTab = activeTab;

        closedTabs.push(backupTab);

        activeTab = new Tab();
        System.out.println(" Opened new tab: " + activeTab);
    }

    public void restoreClosedTab() {
        if (closedTabs.isEmpty()) {
            System.out.println(" No closed tabs to restore!");
            return;
        }

        Tab restored = closedTabs.pop();
        activeTab = restored;

        System.out.println(" Restored Tab: " + activeTab);
        showCurrentPage();
    }

    public void closedTabsInfo() {
        System.out.println(" Closed Tabs Stored in Stack: " + closedTabs.size());
    }
}

public class BrowserBuddy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BrowserManager browser = new BrowserManager();

        while (true) {
            System.out.println("\n=== BrowserBuddy Menu ===");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Print Tab History");
            System.out.println("6. Close Current Tab");
            System.out.println("7. Restore Recently Closed Tab");
            System.out.println("8. Closed Tabs Count");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.visitUrl(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.forward();
                    break;

                case 4:
                    browser.showCurrentPage();
                    break;

                case 5:
                    browser.printActiveHistory();
                    break;

                case 6:
                    browser.closeTab();
                    break;

                case 7:
                    browser.restoreClosedTab();
                    break;

                case 8:
                    browser.closedTabsInfo();
                    break;

                case 9:
                    System.out.println(" Exiting BrowserBuddy. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}
