# Android Project 1 - *Wordle*

Submitted by: **Traven Reese**

**Wordle** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **User has 3 chances to guess a random 4 letter word**
- [x] **After 3 guesses, user should no longer be able to submit another guess**
- [x] **After each guess, user sees the "correctness" of the guess**
- [x] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle betweeen different word lists
- [x] User can see the 'correctness' of their guess through colors on the word 
- [x] User sees a visual change after guessing the correct word
- [ ] User can tap a 'Reset' button to get a new word and clear previous guesses
- [ ] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:
* [X] Wordle like interface

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='Walkthough1.mov' title='Win Game Video Walkthrough' width='' alt='Win Game Video Walkthrough' />
<img src='Walkthough2.mov' title='Lose Game Video Walkthrough' width='' alt='Lose Game Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with ...  
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Describe any challenges encountered while building the app.
One challenge I faced while building this Wordle app was trying to figure out the initial 3X4 Wordle text box design. At first, I tried to create each box individually and build the rows box by box but this was tedious and inefficient. After some research, I found the linear layouts made this more efficient, organized, and easier to implement into the design.

Another challenge I faced was trying to figure out how to move to the next box once the user has entered a letter. After doing some research on similar projects with this functionality, I was able to figure this out as well.

## License

    Copyright [2023] [Traven Reese]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
