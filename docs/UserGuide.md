---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# iVolunteer User Guide

iVolunteer is your dedicated application for volunteer coordination, designed with **volunteer coordinators** in mind. It combines the efficiency of a **Command Line Interface (CLI)** with the advantages of a **Graphical User Interface (GUI)**. If you're looking to enhance your volunteer coordination tasks, iVolunteer is the tool that empowers you to **get things done efficiently**. Whether you're creating events, updating details, or managing volunteers, iVolunteer streamlines the process for **swift and effective coordination**.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) or above installed in your Computer.

1. Download the latest `iVolunteer.jar` from [here](https://github.com/AY2324S1-CS2103T-T14-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for iVolunteer.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar iVolunteer.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `elist` : Lists all events

   * `ecreate n/food donation r/chef r/packer d/23/9/2023 1500 dsc/help food distribution m/50 potatoes b/50.00` : Creates an event with name `food donation`, roles needed `chef` and `packer`, event date `23rd September 2023, 3pm`, description `help food distribution`, materials needed `50 potatoes` and budget `$50`

   * `edelete 3` : Deletes the 3rd event in the current event list

   * `vlist` : Lists all volunteers.

   * `vcreate n/John Doe p/98765432 e/johnd@example.com` : Adds a volunteer named `John Doe` to the list of volunteers.

   * `vdelete 3` : Deletes the 3rd volunteer in the current volunteer list.

   * `vclear` : Deletes all volunteers.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [s/SKILL]` can be used as `n/John Doe s/friendly` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[s/SKILL]…​` can be used as ` ` (i.e. 0 times), `s/friendly`, `s/friendly s/caring` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help: `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Creating a new volunteer's profile: `vcreate`

Volunteer Coordinators can create new volunteer profiles, and add the volunteer into the volunteer list.

Format: `vcreate n/VOLUNTEER_NAME p/PHONE_NUMBER e/EMAIL [s/SKILLS]…`

Parameters:
* n/ - Volunteer name
* p/ - Phone number of the volunteer
* e/ - Email address of the volunteer
* s/ - Skills a volunteer may have

<box type="tip" seamless>

**Tip:** A volunteer can have any number of skills (including 0).
</box>

Restrictions:
* The maximum number of characters of a volunteer name is 30.
* The email must be in a valid format.
* The phone number must be a valid 8-digit Singapore phone number.

Examples:
* `vcreate n/John p/91234567 e/john123@gmail.com` creates a volunteer named `John` with a phone number of `91234567` and an email address of `john123@gmail.com`, with no specific skills. The volunteer profile will be appended to the bottom of the volunteer list.
* `vcreate n/Mary p/92345678 e/mary123@gmail.com s/Cooking s/Carrying heavy goods` creates a volunteer named `Mary` with a phone number of `92345678` and an email address of `mary123@gmail.com`, with two skills: `Cooking` and `Carrying heavy goods`. The volunteer profile will be appended to the bottom of the volunteer list.

### Listing all volunteers: `vlist`

Shows a list of all volunteers in the volunteer list.

Format: `vlist`

### Locating volunteers by name: `vfind` [COMING SOON]

Finds volunteers whose names contain any of the given keywords.

Format: `vfind KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Volunteers matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `vfind John` returns `john` and `John Doe`
* `vfind alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Editing a volunteer: `vedit` [COMING SOON]

Edits an existing volunteer in the volunteer list.

Format: `vedit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SKILL]…​`

* Edits the volunteer at the specified `INDEX`. The index refers to the index number shown in the displayed volunteer list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing skills, the existing skills of the volunteer will be removed i.e adding of skills is not cumulative.
* You can remove all the volunteer’s skills by typing `s/` without
    specifying any skills after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st volunteer to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower s/` Edits the name of the 2nd volunteer to be `Betsy Crower` and clears all existing skills.

### Deleting a volunteer from the volunteer list: `vdelete`

Volunteer coordinators can delete volunteers and remove them from the volunteer list if they no longer wish to volunteer anymore.

Format: `vdelete VOLUNTEER_ID`

* Deletes the volunteer at the specified `INDEX`.
* The index refers to the index number shown in the displayed volunteer list.
* The index **must be a positive integer** 1, 2, 3, …

Restrictions:
* The volunteer ID must be an integer that represents a valid volunteer number in the displayed volunteer list. If there are 30 volunteers in the volunteer list currently displayed to the user, the acceptable values will be from 1-30.

Examples:
* `vlist`, followed by `vdelete 6` will remove the 6th volunteer displayed in the volunteer list.
* `vfind Betsy` followed by `vdelete 1` deletes the 1st volunteer in the results of the `vfind` command.

### Clearing all volunteer entries: `vclear`

Clears all volunteers from the volunteer list.

Format: `vclear`

### Creating an event: `ecreate`

Volunteer Coordinators can create new events.

Format: `ecreate n/EVENT_NAME r/ROLES_NEEDED… sd/START_DATETIME [ed/END_DATETIME] l/LOCATION dsc/DESCRIPTION [m/MATERIALS_AND_LOGISTICS_NEEDED]... [b/BUDGET]`

Parameters:
* n/ - Event name
* r/ - Roles needed for the event
* sd/ - Start date and time of the event
* ed/ - End date and time of the event
* l/ - Location of the event
* dsc/ - Description of the event
* m/ - Materials needed for the event
* b/ - Budget for the event

Restrictions:
* All parameters must be separated by a single space.
* All arguments cannot be blank.
* The date and time formats must be exactly `DD/MM/YYYY TTTT`.
* If the end date and time is specified, it must be the _same time_ or _after_ the start date and time of the event.
* The budget argument must be a floating point number with 2 decimal places.

<box type="tip" seamless>

**Tip:** If the end date and time is not specified, iVolunteer will automatically set the end date and time to **exactly 3 hours** after the start date and time.
</box>

Examples:
* `ecreate n/food donation r/chef r/packer sd/23/9/2023 1500 l/nus dsc/help food distribution m/50 potatoes b/50.00` creates an event with name `food donation`, roles needed `chef` and `packer`, event date from `23rd September 2023, 3pm` to `23rd September 2023, 6pm`, location `nus`, description `help food distribution`, materials needed `50 potatoes` and budget `$50.00`
* `ecreate n/clean beach r/cleaner sd/30/11/2023 1200 ed/30/11/2023 1800 l/east coast park dsc/help clean east coast park m/cleaning supplies m/trash bags b/50.00` creates an event with name `clean beach`, roles needed `cleaner`, event date from `30th November 2023, 12pm` to `30th November 2023, 6pm`, location `east coast park`, description `help clean east coast park`, materials needed `cleaning supplies` and `trash bags` and budget `$50.00`

### Listing all events: `elist`
Volunteer coordinators can see all the events they are organising. For each event, only the most important information will be shown: name, start date and time, end date and time, location, and description.

Format: `elist`

### Reading an individual event: `eshow`
Volunteer coordinators can read up more about an individual event, to familiarize themselves with its requirements while planning for it.

Format: `eshow EVENT_ID`

Restrictions:
* First part must be `eshow`
* Second part must be an integer that represents a valid `EVENT_ID`: If the list of events displayed is 10 events long, the acceptable values will be from 1-10.
* First and second parts must be separated by a single space.

Examples:
* `eshow 7` will result in a pop-up window appearing, listing all details of the event at id `7`. This includes its name, start date and time, end date and time, location, roles needed, logistics needed (if any), budget (if any), and a description.

### Sorting all events by date: `esort`

Volunteer coordinators can sort all events by their date and time, in ascending order, to see the few most upcoming events.

Format: `esort`

### Deleting an event: `edelete`

Deletes the event from the event list.

Format: `edelete EVENT_ID`

* Deletes the event at the specified `id`.
* The id refers to the index number shown in the displayed event list.
* The id **must be a positive integer** 1, 2, 3, …​

Examples:
* `elist` followed by `edelete 2` deletes the 2nd event in the event list.
* `efind Beach cleaning` followed by `edelete 1` deletes the 1st event in the results of the `find` command (tentative feature)

### Clearing all event entries: `eclear`

Clears all entries from the event list.

Format: `eclear`

### Adding a volunteer into an event: `eaddv` [COMING SOON]

Adds a volunteer to an event by id or name.

Format: `eaddv vid/VOLUNTEER_ID eid/EVENT_ID` or `eaddv vn/VOLUNTEER_NAME en/EVENT_NAME`

Parameters:
* vn/ - Volunteer name
* vid/ - Volunteer id
* eid/ - Event id
* en/ - Event name

Restrictions:
* The maximum number of characters of the event and volunteer is 50.
* The event and volunteer name entered must exist.
* The event id must be greater than or equal to 0 and lesser than the number of events existed.
* The volunteer id must be greater than or equal to 0 and lesser than the number of volunteers existed.

Examples:
* `eaddv vid/1 eid/1`
* `eaddv vn/Betsy Crowe en/fundraising`

### Listing all volunteers in an event: `elistv` [COMING SOON]

Shows a list of all volunteers in an event.

Format: `elistv eid/EVENT_ID` or `elistv en/EVENT_NAME`

Parameters:
* eid/ - Event id
* en/ - Event name

Restrictions:
* The maximum number of characters of the event is 50.
* The event name entered must exist.
* The event id must be greater than or equal to 0 and lesser than the number of events existed.

Examples:
* `elistv eid/1`
* `elistv en/fundraising`

### Removing a volunteer in an event: `eremovev` [COMING SOON]

Removes the specified volunteer from an event by name or id.

Format: `eremovev vid/VOLUNTEER_ID eid/EVENT_ID` or `eremovev vn/VOLUNTEER_NAME en/EVENT_NAME`

Parameters:
* vn/ - Volunteer name
* vid/ - Volunteer id
* en/ - Event name
* eid/ - Event id

Restrictions:
* The maximum number of characters of the event is 50.
* The event and volunteer name entered must exist.
* The maximum number of characters of a volunteer name is 30.
* The id must not exceed the number of volunteers in the event and greater or equal to 0.

Examples:
* `eremovev vid/1 eid/1`
* `eremovev vn/John en/fundraising`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

iVolunteer data are saved in the hard disk automatically after any command executed. There is no need to save manually.

### Editing the data file

iVolunteer data are saved automatically as two JSON files, `[JAR file location]/data/volunteerStorage.json` (volunteer storage) and `[JAR file location]/data/eventStorage.json` (event storage and _event-volunteer interactions_). Advanced users are welcome to update data directly by editing both data files.

_**Note:** Event-volunteer interactions through `eaddv`, `elistv`, `eremovev` coming in v1.3!_

<box type="warning" seamless>

**Caution:**
If your changes to any data file makes its format invalid, iVolunteer will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: As a Windows 11 user, how do I open a command terminal?<br>
**A**: On your Windows 11 computer, do the following:
1. Select the Start Menu (the Windows icon) in the taskbar, or press the Windows key.
2. Type `cmd` in the search bar.
3. Select Command Prompt from the list.

**Q**: As a Mac user, how do I open a command terminal?<br>
**A**: On your Mac, do one of the following:
1. Click the Launchpad icon in the Dock, type Terminal in the search field, then click Terminal. 
2. In the Finder, open the `/Applications/Utilities` folder, then double-click Terminal.

--------------------------------------------------------------------------------------------------------------------

## Known issues

coming soon

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                                        | Format, Examples                                                                                                                                                                                                                                                                       |
|-----------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Create a new event**                        | `ecreate n/EVENT_NAME r/ROLES_NEEDED… d/DATE_AND_TIME l/LOCATION dsc/DESCRIPTION [m/MATERIALS_AND_LOGISTICS_NEEDED]... [b/BUDGET]` <br> e.g., `ecreate n/Fundraising at Orchard r/logistics leader d/23-09-2023 1500 dsc/station at locations to ask for donations m/50 tin cans b/50` |
| **List all events**                           | `elist`                                                                                                                                                                                                                                                                                |
| **Read an individual event**                  | `eshow EVENT_ID` <br> e.g., `eshow 8`                                                                                                                                                                                                                                                  |
| **Sort all events by date and time**          | `esort`                                                                                                                                                                                                                                                                                |
| **Delete an event**                           | `edelete EVENT_ID` <br> e.g., `edelete 3`                                                                                                                                                                                                                                              |
| **Create a new volunteer profile**            | `vcreate vn/VOLUNTEER_NAME hp/PHONE_NUMBER e/EMAIL [s/SKILLS]...`<br> e.g.,`vcreate vn/John Lim hp/81234567 e/john123@gmail.com s/Cooking`                                                                                                                                             |
| **List all volunteer profiles**               | `vlist`                                                                                                                                                                                                                                                                                |
| **Delete a volunteer profile**                | `vdelete VOLUNTEER_ID` <br> e.g., `vdelete 4`                                                                                                                                                                                                                                          |
| **Add a volunteer to an event**               | `eaddv vid/VOLUNTEER_ID eid/EVENT_ID`<br> e.g., `eaddv vid/1 eid/3` <br> Alternatively, `eaddv vn/VOLUNTEER_NAME en/EVENT_NAME` <br> e.g., `eaddv vn/Betsy Crowe en/Fundraising for needy families`                                                                                    |
| **Check for volunteers assigned to an event** | `elistv eid/EVENT_ID` <br> e.g. `elistv eid/8` <br> Alternatively, `elistv en/EVENT_NAME` <br> e.g., `elistv en/October beach clean up`                                                                                                                                                |
| **Remove a volunteer from an event**          | `eremovev vid/VOLUNTEER_ID eid/EVENT_ID`<br> e.g., `eremovev vid/3 eid/4` <br> Alternatively, `eremovev vn/VOLUNTEER_NAME en/EVENT_NAME` <br> e.g., `eremovev vn/John Lim en/October beach clean up`                                                                                   |
