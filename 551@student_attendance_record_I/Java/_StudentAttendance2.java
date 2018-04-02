public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");      //借用正则匹配
}