@tag
Feature: dayonePOM task

  @dayonePOM
  Scenario: to click on nested frames and get texts
    Given navigate to the url
    And click on nested frames link
    Then Navigate to each frame and get the text of that frame then print it.

  @daytwo
  Scenario: daytwo task working on guru99.com application
    Given open the browser and navigate to url
    Then click on search icon in the top menu list then provide java then close the search window.
    And get the values of only SAP Module and print the values and in the same way for enterprize testing
    Then click on Java tile under top tutorial section and get the lessons and print them.
