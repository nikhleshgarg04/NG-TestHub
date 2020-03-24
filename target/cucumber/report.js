$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/dummyfeature.feature");
formatter.feature({
  "name": "first driver test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "login to given url",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "i have a url and login credentials \"niksgr8904\" and \"nikhlesh1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "MS1Stepdef.i_have_a_url_and_login_credentials_and(String,String)"
});
formatter.result({
  "status": "passed"
});
});