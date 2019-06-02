Readme assignment 3 : 

_____Events_____ : 

turnOn - Turn the machine on
turnOff - turn the machine off
internetOn - Internet is on
InternetOff - Internet is off
fileRequest - A request to download file -** when using file request use the event name and wait for number promt to enter ***
downloadAborted - The user canceled the file download
downloadError - There is an error in the download
errorFixed - The error has been fixed
movieOn - A reuqest to play the downloaded file
restartMovie - Restart the movie
holdMovie - A request to hold the movie player
movieOff - A request to shut down the player
resume - A request to resume the player
IncreaseSpace - A request to increase disk space ** when using increase space use the event name and wait for number prompt to enter **


_____States_____ : 
Off - The machine is powered off
On - The machine is powered on
Disk - Region of disk
Download - Region of Download
	CheckingSpace - Checking Space of the download
	ConnectionWait - Waiting for connection of the download
	DownloadProgress - The download is in progress
	Error - The download has an error
	Idle - The machine is waiting for a request to download a file
InternetConnection - Region of the network state of the machine
	HaveConnection - The machine has internet connection
	NoConnection - The machine doesn't have internet connection
MoviePlayer - Region of the movie player in the machine
	Hold - The player is in hold state
	Ininitialize - The player initialize the movie
	MovieIdle - The Player is in Idle mode
	Play - The play is in play mode
User - Region of the user state in the machine
	Advanced - The user is in advanced state
	Beginner - The user is in beginner state
	Professional - The user is in professional state

_____Using the Program_____ : 
The program will wait for event name prompt (from the list above)
if you wish to use fileRequest or IncreaseSpace please write the event name to the console and then wait for a prompt to enter number.

_____assumptions_____ : 
In the office hours there has been a discussion that we should not use threads in this assignment and only having an example of a working system.
There are few methods that require threading in this assignment but we didn't use it because we understood otherwise.
Because of the misunderstanding and the fact that one of our members that worked on it observe Shabbat and the clarification was in Shabbat we could not Implement a context switch or make a big change in our software.




