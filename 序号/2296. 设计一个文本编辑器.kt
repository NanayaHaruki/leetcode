class TextEditor() {
  val l = StringBuilder()
  val r = StringBuilder()
  fun str():String {
      val start = max(0,l.length-10)
      return l.substring(start)
  }
  fun addText(text: String) {
      l.append(text)
  }

  fun deleteText(k: Int): Int {
      val t = min(k,l.length)
      l.setLength(l.length-t)
      return t
  }

  fun cursorLeft(k: Int): String {
      var i = k
      while(l.isNotEmpty() && i>0){
          r.append(l.last())
          l.setLength(l.length-1)
          --i
      }
      return str()
  }

  fun cursorRight(k: Int): String {
      var i = k
      while(i>0 && r.isNotEmpty()){
          l.append(r.last())
          r.setLength(r.length-1)
          --i
      }
      return str()
  }
}
/**
* Your TextEditor object will be instantiated and called as such:
* var obj = TextEditor()
* obj.addText(text)
* var param_2 = obj.deleteText(k)
* var param_3 = obj.cursorLeft(k)
* var param_4 = obj.cursorRight(k)
*/