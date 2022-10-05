fun subdomainVisits(cpdomains: Array<String>): List<String> {
  val d = mutableMapOf<String,Int>()
  for (s in cpdomains){
    var cnt = 0;var domainStart =0
    for (i in s.indices){
      if (s[i]==' '){
        cnt = s.substring(0,i).toInt()
        domainStart=i+1
        val url = s.substring(domainStart)
        d[url]=d.getOrDefault(url,0)+cnt
      }else if(s[i]=='.'){
        val url = s.substring(i+1)
        d[url]=d.getOrDefault(url,0)+cnt
      }
    }
  }
  val ans = mutableListOf<String>()
  for ((url,cnt) in d){
    ans.add("$cnt $url")
  }
  return ans
}