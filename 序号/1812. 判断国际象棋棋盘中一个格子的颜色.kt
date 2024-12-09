class Solution {
  fun squareIsWhite(coordinates: String): Boolean {
      return return (coordinates[0]-'a'+ (coordinates[1]-'1')).and(1)==1
  }
}