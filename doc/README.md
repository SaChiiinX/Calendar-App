This application is designed to contain and display information about various vassar organizations and events. Users are able to see vassar events and club meetings at each selected date and decide whether or not they want to go. Additionally, users are able to add events to the general database and remove events as well. This version of the application will be only accessible by a user of the administrative level where they can freely add and remove events. The app is split into several functionalities which includes a calendar, event adding, event removal, as well as club/event searching. After authentication a user will have the option to navigate to any of these functionalities through a navigation bar located in the top left corner.

Login- Users enter an authentication page that requires a username/email and password. For this version, the user is granted administrator privileges and can freely add and remove events from the database. However our app doesnt currently have it implemented.

Calendar- Calendar has two view modes, one where users can see all the dates in the month and swap between months. The other view is a week view where users can see each individual week in the calendar. In the weekview, users can also see a display of all events occurring in that day. While selecting the date in the month view, the events will not be directly shown but the date is preserved when swapping to week view mode where the events will be displayed. Currently we are able to populate a list with the events for the specific date but unable to update the recycler view to view them.

Search:
Users can enter a search query to see a list of events and clubs stored inside the database. These results will also display other information such as the meeting location, meeting date, and meeting time. Works as intended.

Add event 
Users are able to add events to the shared calendar by inputting the event name, the meeting location, the meeting date, and the meeting time. This will store an occurrence of the event in the database with the information. Users can also choose to make the event repeated weekly by toggling the switch on. This will create copies of the event with different dates. A notification will be displayed when the event(s) has been successfully added to the database. 

Remove event 
While this is more of an administrative feature, for this version, users can remove events from the database by inputting the name of an event which will remove all occurrences of that event from the database, even if there are clones. 
