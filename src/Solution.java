import java.util.*;

/**
 * The BrowserHistory class represents a browser with a history of visited URLs.
 */
class BrowserHistory {
    private Deque<String> backHistory;
    private Deque<String> forwardHistory;
    private String currentUrl;

    /**
     * Initializes the BrowserHistory object with the given homepage.
     *
     * @param homepage The URL of the homepage to start with.
     */
    public BrowserHistory(String homepage) {
        backHistory = new LinkedList<>();
        forwardHistory = new LinkedList<>();
        currentUrl = homepage;
    }

    /**
     * Visits the given URL and clears the forward history.
     *
     * @param url The URL to visit.
     */
    public void visit(String url) {
        backHistory.push(currentUrl);
        currentUrl = url;
        forwardHistory.clear();
    }

    /**
     * Moves back in the history by the given number of steps, or as many steps as
     * possible if there aren't enough steps in the history.
     *
     * @param steps The number of steps to move back in the history.
     * @return The current URL after moving back in history.
     */
    public String back(int steps) {
        while (steps > 0 && !backHistory.isEmpty()) {
            forwardHistory.push(currentUrl);
            currentUrl = backHistory.pop();
            steps--;
        }
        return currentUrl;
    }

    /**
     * Moves forward in the history by the given number of steps, or as many steps
     * as possible if there aren't enough steps in the history.
     *
     * @param steps The number of steps to move forward in the history.
     * @return The current URL after moving forward in history.
     */
    public String forward(int steps) {
        while (steps > 0 && !forwardHistory.isEmpty()) {
            backHistory.push(currentUrl);
            currentUrl = forwardHistory.pop();
            steps--;
        }
        return currentUrl;
    }
}

class Solution{
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("https://www.google.com");
        browser.visit("https://www.facebook.com");
        browser.visit("https://www.amazon.com");
        System.out.println(browser.back(1)); // output: https://www.facebook.com
        System.out.println(browser.back(1)); // output: https://www.google.com
        System.out.println(browser.forward(1)); // output: https://www.facebook.com
        browser.visit("https://www.netflix.com");
        System.out.println(browser.forward(2)); // output: https://www.netflix.com
        System.out.println(browser.back(3)); // output: https://www.google.com
    }

}
