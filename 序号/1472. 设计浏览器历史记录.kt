class BrowserHistory(homepage: String) {
  private val stack = mutableListOf<String>().apply { add(homepage) }
  private var idx = 0
  fun visit(url: String) {
      while (stack.size>idx+1) stack.removeLast()
      stack.add(url)
      idx+=1
  }

  fun back(steps: Int): String {
      idx = if (idx-steps<=0) 0 else idx-steps
      return stack[idx]
  }

  fun forward(steps: Int): String {
      idx = if (idx+steps>=stack.size)  stack.lastIndex else idx+steps
      return stack[idx]
  }

}

/**
* Your BrowserHistory object will be instantiated and called as such:
* var obj = BrowserHistory(homepage)
* obj.visit(url)
* var param_2 = obj.back(steps)
* var param_3 = obj.forward(steps)
*/