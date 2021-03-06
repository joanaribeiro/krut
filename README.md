# krut

Krut Computer Recorder

[![Download Krut Computer Recorder](https://img.shields.io/sourceforge/dw/krut.svg)](https://sourceforge.net/projects/krut/files/latest/download)

- [Running Krut on Windows](#running-krut-on-windows)
- [Video recording](#video-recording)
- [Sound Recording](#sound-recording)
- [Files](#files)
- [Timer](#timer)
- [Moving the capture area during recording](#moving-the-capture-area-during-recording)
- [Preview Window](#preview-window)
- [Compiling and Running](#compiling-and-running)
- [Ubuntu Readme](#ubuntu-readme)

## Running Krut on Windows

Here are some quick instructions on how to run the program on the newer versions of Windows. (You need to have Java installed, but there is a good chance that you already do. Otherwise, see below.) 
 
To run the program, it is usually sufficient to just double click on "KRUT.jar" or "krut.bat", after you have extracted the zip-archive into a folder of your choice (you have to extract the archive somewhere). 
 
If you double click "KRUT.jar", and the program doesn't start, but you get a list of programs to choose from instead, you should choose the one that says "Java (something)". If you click the "always use the selected program..." check box at the bottom of the list, you will not have to repeat this step the next time you want to run the program. 
 
If double clicking does not work at all, try right clicking and see if there are any "Open With"-alternatives. If there is an "Open With -> Java (something)" alternative, that should do it. Again, if you click the "always use the selected program..." check box, you will not have to repeat this step the next time you want to run the program. 
 
If there is no "Open With" alternative when you right click, try to hold down a Shift-button while you right click, and see if there is an "Open With" alternative now. 
 
If none of this works, there is probably some problem with your Java-installation. Go to a Java download site (at the time of writing http://www.java.com/getjava), and download and reinstall your Java.



## Video recording

Video can be recorded at a given frame rate (fps), and played back at another. If the recording fps is changed, the playback fps will be changed along with it, so the playback fps must be changed afterwards.

The capture area on the screen is chosen like this:

* Press either one of the mouse pointer buttons (in the main window or in the Settings window)
* Move the mouse to the TOP LEFT corner of the capture area.
* Press and hold CTRL.
* Move the mouse to the BOTTOM RIGHT corner of the capture area.
* Release CTRL.

The capture area can also be set manually in the Settings window. The capture area can be checked by clicking the "Snap" button, before recording.

For a description on how to disable graphics overlay to enable video recording from a media player using graphics overlay, see the readme-files and video files.



## Sound Recording


For a general description on how to enable sound recording, please see the readme-files in each release.

The sound recording can currently only be done in the wav format. Encoding in other formats might be added. In the mean time, the recorded wav-file can be used for manual encoding into whatever format is wanted. If a suitable encoder for the mp3 format is released for in java, it is very likely that it will be added to Krut. At the time of writing, no such encoder has been found.

Sound synchronization works by comparing the recorded time of sound to the system clock. Since video synchronization uses the same principle, this will ensure that sound is synchronized to video, as long as sound synchronization is active. However, if the system clock and the clock of the device playing the sound run at different speeds, this may mean that both sound and video are recorded at the wrong speed.

If video recording and video playback are set to different frame rates, sound will stay synchronized to the video track, instead of the system clock.

Sound synchronization is necessary to maintain sync between audio and video in longer movies, since random frames will inevitably be lost in the recording process.

The other settings for sound recording should hopefully be self explanatory.



## Files

Files can be selected by either entering the file name directly into the file name field in the Settings window, or by using the browser for each file. If the �overwrite save files� check box is checked, the written files will have the chosen file names, otherwise the program will find the first available file name by adding numbers.

The following files are produced by the program:

Audio files	-	wav files containing the recorded audio tracks.
Image files	-	jpg files containing the recorded snapshots.
Movie files	-	mov files containing the recorded movies.

In addition to these files, mov files of the names temp1.mov, temp2.mov etc. are produced, containing only video data. These temp files are located in the same directory as the movie files. If there is no audio recording, only the temp files will be produced.

After recording, the temp files and the audio files can be used to create new movie files using other software.

All the files mentioned so far will remain after the program is closed, and will have to be deleted manually.

There are also temporary storage files created in the home directory of the program. These files will remain after the program is closed, but they will contain no data.


## Timer

The timer allows you to start the recording of the selected capture area (or sound only) at a selected time. The starting time of the recording can be given either by specifying a delay, or by specifying a clock-time. The time to stop recording can also be given.


## Moving the capture area during recording

It is possible to have the capture area follow the mouse pointer position during recording. The movements of the capture area are determined by normal acceleration mechanics, which are fairly pleasing to the eye. When the mouse pointer gets close to the edge of the capture area, the capture area is re-centered around the position of the mouse pointer, as soon as the mouse pointer stops moving. Using this method, the entire screen can be shown in an instructional video with smaller dimensions.

Learning to move the capture area smoothly can take some practice. The best results come from simply moving the mouse pointer directly to the point which should be the new center of the capture area, and then holding the mouse pointer still for a couple of seconds while the capture area moves.

To allow the best possible use of the screen during a video with a moving capture area, it is recommended that the Preview Window is used.

## Preview Window

The Preview Window displays a preview of the film being recorded, while it is recorded. The window is useful to make sure that the mouse pointer is inside the capture area. Alternatively if the capture area follows the mouse, the Preview Window is very useful to make sure that the capture area is positioned correctly after each movement.

On slower computer systems, the Preview Window can be a strain on the system resources, causing primarily the audio quality to suffer.

## Compiling and Running
 
To compile and run Krut, start by extracting the contents of this zip-file to a new folder.
   
To compile the source code, the file jmf.jar must be included in the classpath. To obtain the file, download a version of krut other than the pure source code version, and copy the folder jmf into the folder where the contents of this zip-file have been extracted. An alternative way to obtain the file jmf.jar is to follow the information on http://java.sun.com/javase/technologies/desktop/media/jmf/index.jsp.
  
Open a console (command prompt), and go to the folder where the contents of this zip-file were extracted. To clarify: There should be a folder named "krut" in the folder where you now stand.
   
Assuming the file jmf.jar is placed in the path /jmf/lib/jmf.jar relative to the folder where you now stand, to compile Krut, type:  <Path to javac executable>javac -cp ./jmf/lib/jmf.jar;. ./krut/Run_KRUT.java
   
After that, to run the compiled program, type: java -cp ./jmf/lib/jmf.jar;. krut.Run_KRUT.java

## Ubuntu Readme

If you have downloaded the zip-archive meant for ubuntu, you have in the archive an instructional video (the file sound_ubuntu.mov) on how to enable sound recording. The procedure in that video is based on empirical research on one single machine (a Dell Inspiron 6000), and the author has no real insight into what he is doing in that video. He just knows that it works for him, and that it also makes other sound-capturing software in ubuntu suddenly start to function (such as the Sound Recorder).

Although the author has the deepest respect for the hard work that has gone into ubuntu, and the people that have performed it, a quick google search reveals that there is obviosly something seriosly wrong with sound recording in ubuntu at this stage. In the light of this insight, the author has chosen not to delve further into the causes of the problem, nor into the consequences of its suggested solution.

Everything in the instructional video was done on the Ubuntu distribution Breezy Badger. Please note that in newer distributions of Ubuntu, the procedure for enabling audio recording has most likely been simplified or changed.

In short, do this at your own risc. A practical(?) trick would be to record yourself doing it, so you can backtrack in case something was damaged.