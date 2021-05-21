#Author: glauber.fernando@gmail.com

@busca
Feature: navegate in chrome

  @Positivo
  Scenario: search in Correios
    Given With the browser open
    And I enter the Correios page
    When So I search for CEP

  Scenario: search in Correios
    Given With the browser open
    And I enter the Correios page
    When So I search for Logradouro

