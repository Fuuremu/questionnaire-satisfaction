# questionnaire-satisfaction

@startuml

  title Questionnaire de satisfaction - Class Diagram

class Apprenant {
  +Int idApprenant
  +String nomApprenant
  +String prenomApprenant
  +String emailApprenant
}
class Formation {
  +Int idFormation
  +String ThemeFormation
  +Int idFormateur
}
class Formateur {
  +Int idFormateur
  +String nomFormateur
  +String prenomFormateur
}
class FormationApprenant {
  +Int idFormation
  +Int idApprenant
  +String nomFormateur
  +String prenomFormateur
}
class Note {
  +Int idNote
  +Int idApprenant
  +Int idFormation
  +Int note1
  +Int note2
  +Int note3
  +Int note4
}

Apprenant"0..*"--"1..*"Formation
Formateur"0..*"--"1..1"Formation
(Apprenant, Formation) . FormationApprenant
FormationApprenant"1"-->"1"Note

@enduml
