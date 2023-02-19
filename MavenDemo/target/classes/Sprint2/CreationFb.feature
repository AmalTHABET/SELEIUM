@TNR1
Feature: Creation Compte Facebook
  On va creer un Compte Facebook

  @tag1
  Scenario: Creation Compte
    Given Ouvrir le navigateur
    And Ouvrir l URL 
    And Cliquer sur le bouton Creer un  compte
    
    When Saisir le nom
    And Saisir le prenom
    And Saisir l email
    And Saisir l email confirme
    And Saisir le password
    And Saisir la date de naissance
    And Selectionner le genre
    And Cliquer sur le bouton Inscription
     
    Then Compte cree

