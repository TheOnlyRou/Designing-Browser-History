# Designing Browser History

You have a **browser** of one tab where you start on the `homepage` and you can visit another `url`, get back in the history number of `steps` or move forward in the history number of `steps`.

Implement the `BrowserHistory` class:

- `BrowserHistory(string homepage)` Initializes the object with the `homepage` of the browser.
- `void visit(string url)` Visits `url` from the current page. It clears up all the forward history.
- `string back(int steps)` Move `steps` back in history. If you can only return `x` steps in the history and `steps > x`, you will return only `x` steps. Return the current `url` after moving back in history **at most** `steps`.
- `string forward(int steps)` Move `steps` forward in history. If you can only forward `x` steps in the history and `steps > x`, you will forward only `x` steps. Return the current `url` after forwarding in history **at most** `steps`.

**Example:**

**Input:**

```
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
```



**Output:**

```
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
```




**Explanation:**

```
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
browserHistory.back(1); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
browserHistory.back(1); // You are in "facebook.com", move back to "google.com" return "google.com"
browserHistory.forward(1); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
browserHistory.forward(2); // You are in "linkedin.com", you cannot move forward any steps.
browserHistory.back(2); // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
browserHistory.back(7); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
```

**Constraints:**

- `1 <= homepage.length <= 20`
- `1 <= url.length <= 20`
- `1 <= steps <= 100`
- `homepage` and `url` consist of  '.' or lower case English letters.
- At most `5000` calls will be made to `visit`, `back`, and `forward`.

## Explanation & Solution

### Understanding the problem

The problem describes a browser with a history of visited URLs. The browser starts on a homepage and can visit other URLs, go back a certain number of steps in the history, or go forward a certain number of steps in the history.

To solve this problem, we need to create a class called `BrowserHistory` with the following methods:

- `BrowserHistory(String homepage)`: Constructor that initializes the object with the given homepage.
- `visit(String url)`: Method that visits the given URL, clears the forward history, and adds the URL to the back history.
- `back(int steps)`: Method that moves back in the history by the given number of steps, or as many steps as possible if there aren't enough steps in the history. Returns the current URL after moving back in history.
- `forward(int steps)`: Method that moves forward in the history by the given number of steps, or as many steps as possible if there aren't enough steps in the history. Returns the current URL after moving forward in history.

### Solving the problem

To solve this problem, we can use two stacks to keep track of the back history and forward history of visited URLs. When the `visit` method is called, we push the new URL onto the back history stack and clear the forward history stack. When the `back` method is called, we pop the top `steps` URLs from the back history stack and push them onto the forward history stack. We return the top URL from the back history stack as the current URL. When the `forward` method is called, we pop the top `steps` URLs from the forward history stack and push them onto the back history stack. We return the top URL from the forward history stack as the current URL.

Here's the basic algorithm for each method:

- `BrowserHistory(String homepage)`: Initialize the back history stack with the given homepage.
- `visit(String url)`: Push the new URL onto the back history stack, clear the forward history stack.
- `back(int steps)`: Pop the top `steps` URLs from the back history stack and push them onto the forward history stack. Return the top URL from the back history stack as the current URL.
- `forward(int steps)`: Pop the top `steps` URLs from the forward history stack and push them onto the back history stack. Return the top URL from the forward history stack as the current URL.
