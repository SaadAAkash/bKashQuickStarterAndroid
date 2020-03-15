## Quick Starter Android Boilerplate for Easy bKash Integration

[![GitHub license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)]()  [![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)]() [![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/) [![made-with-love](https://img.shields.io/badge/Made%20with-Love-1f425f.svg)](https://saad.ninja)


An app with a simple easy-to-start boilerplate codebase for integrating bKash with ease. The whole app is developed using Kotlin with layers-by-features packaging & other standard practices.

## Features

* A Simple App with a button to `Pay with bKash`
* Pressing the button initiates bKash payment dialogs
* Returns a screen with success & payment status if the mock payment is successful

## Build Instructions

This project uses the Gradle build system. To build this project, use the `gradlew build` command or use "Import Project" in Android Studio.

### Prerequisites

* Android Studio 3.5+. The latest version can be downloaded from [here](https://developer.android.com/studio/)
* Build gradle 3.5.0+
* Android SDK 29
* Kotlin Version 1.3.61+

### Install the apk

Head over to ```Releases``` in the repo and download the apk file from the latest release.

## App Screenshots

<img src="https://github.com/SaadAAkash/bKashQuickStarterAndroid/blob/master/Resources/Screenshots/1.jpg" height="400" width="200"> <img src="https://github.com/SaadAAkash/bKashQuickStarterAndroid/blob/master/Resources/Screenshots/2.jpg" height="400" width="200"> <img src="https://github.com/SaadAAkash/bKashQuickStarterAndroid/blob/master/Resources/Screenshots/3.jpg" height="400" width="200"> <img src="https://github.com/SaadAAkash/bKashQuickStarterAndroid/blob/master/Resources/Screenshots/4.jpg" height="400" width="200"> <img src="https://github.com/SaadAAkash/bKashQuickStarterAndroid/blob/master/Resources/Screenshots/5.jpg" height="400" width="200">

## Contributing

### Directory Structure

The following is a high level overview of relevant files and folders.

```
bKashQuickStarterAndroid/
├── app/
│   ├── build/
│   ├── libs/
│   └── src/     
│       └── main/
│           ├── assets/
│           │	└── www/
│           │		└── css, fonts, js & html files 
│           ├── java/
│           ├── res/
│           └── AndroidManifest.xml
├── build/ 
│   └── kotlin/      
│       └── sessions/
│           └── ...
├── gradle/ 
│   └── wrapper/      
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── Resources/
│   └── Screenshots
│       └── ... 
├── build.gradle
├── _config.yml
├── gradle.properties
├── local.properties
├── settings.gradle
├── README.md
└── ...

```

### File Uses

* ```<PROJECT_ROOT>\build.gradle``` : Top-level build file with configuration options common to all sub-projects/modules
* ```<PROJECT_ROOT>\app\build.gradle``` : Gradle specific for app module with libraries used
    * If you use another module in your project, as a local library, you would have another build.gradle file: ```<PROJECT_ROOT>\module\build.gradle```

### Create a branch

1.  `git checkout master` from any folder in your local `bKashQuickStarterAndroid`
    repository
1.  `git pull origin master` to ensure you have the latest main code
1.  `git checkout -b the-name-of-my-branch` (replacing `the-name-of-my-branch`
    with a suitable name) to create a branch

### Make the change

1.  Change/Add the codes
1.  Save the files and check the codes if it has successfl build config.

### Test the change

1.  If possible, test the codes the way you want.

### Push it

1.  `git add -A && git commit -m "My message"` (replacing `My message` with a
    commit message, such as `Fixed App Crash` or `Added App Crash 28 Fix`) to stage and commit
    your changes
1.  `git push my-fork-name the-name-of-my-branch`
1.  Go to the
    [`bKashQuickStarterAndroid`](https://github.com/SaadAAkash/bKashQuickStarterAndroid/)
    and you should see recently pushed branches.
1.  Follow GitHub's instructions and open up a pull request.
1.  If possible, include screenshots of visual changes.
