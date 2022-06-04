fun numUniqueEmails(emails: Array<String>): Int {
  val set = mutableSetOf<String>()
  for (s in emails){
    val (person,org) = s.split('@')
    var personTmp = ""
    for (i in person.indices){
      val c = person[i]
      if (c=='+')break
      if (c=='.') continue
      personTmp+=c
    }
    set.add("$personTmp@$org")
  }
  return set.size
}