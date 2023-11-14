---
  layout: default.md
  title: "tiongMax's Project Portfolio Page"
---

### Project: iVolunteer

iVolunteer is an application for volunteer coordinators to manage volunteers, events, and their interactions. The user 
interacts with it using a CLI, with a GUI created with JavaFX. It is written in Java with about 14 kLoC.

Given below are my contributions to the project.

* **New Feature**: Enhanced functionality for Event Delete command. [#89](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/89).
  * Description: Delete event with index from the event list.
  * Highlights: The implementation itself is not too difficult but tedious due to the refactor of every related file
    including test cases.

* **New Feature**: Edit event detail feature [#113](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/113).
  * Description: Edit the detail of an event.
  * Highlights: The implementation itself is not too difficult since it is adapted from AB3. However, for some parts like 
    start and end date, I have to figure it out myself on how to validate the update of start time and end time before
    editing the event. Other than that, it was tedious and challenging as I have to refactor the every file that are 
    related to this feature including test cases when our team decided to add on or remove fields from the command as 
    time goes on. [#221](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/221).

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=tiongMax&breakdown=true)

* **Project management**: 
    * Help set up the issue tracker and milestone management on GitHub.
    * Help initiating group meetings on Zoom.

* **Documentation**: 
  * User Guide: 
    * Added documentation for the event add volunteer, event remove volunteer and event list volunteer features (`eaddv`
      , `eremovev`, `elistv`): [#52](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/52).
    * Added documentation for the event edit feature (`eedit`): [#203](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/203).
    * Added more details for documentation of find event feature: [#251](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/251).

  <div style="page-break-after: always;"></div>
  
  * Developer Guide:
    * Added a list of user stories: [#65](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/65).
    * Added use cases for eaddv, eremovev, eedit and elistv: [#229](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/229).
    * Added implementation details for event delete and event edit features and planned enhancement: 
      [#234](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/234).
    * Added instructions for Manual Testing section to give testers guidance on using our app: 
      [#238](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/238).
    
* **Community**: 
  * Some PRs reviewed (with non-trivial review comments): [#131](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/131), 
    [#218](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/218), [#236](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/236), 
    [#240](https://github.com/AY2324S1-CS2103T-T14-4/tp/pull/240).
    
  * Reported bugs for other teams in the cohort: [#1](https://github.com/AY2324S1-CS2103T-T13-0/tp/issues/217),
    [#2](https://github.com/AY2324S1-CS2103T-T13-0/tp/issues/215).
