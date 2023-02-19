
@tag
Feature: Aurhentification orange
  Nous allons faire l authentification de site Orange

  @tag1
  Scenario: Authentification validee
    Given Ouvrir l URL de l application

    When Saisir Login
    And Saisir mot de passe

    Then Ouvrir page d acceuil

