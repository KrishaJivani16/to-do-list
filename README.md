# to-do-list

## Project Overview
This is a simple To-Do List Android application built using Java and SQLite. It allows users to add, update, delete, and view tasks.

## Project Structure
```
To-Do-List/
│-- app/
│   │-- src/
│   │   │-- main/
│   │   │   │-- java/com/example/todo_list/
│   │   │   │   │-- MainActivity.java
│   │   │   │   │-- DatabaseHelper.java
│   │   │   │-- res/layout/
│   │   │   │   │-- activity_main.xml
│   │-- build.gradle.kts
│-- gradle.properties
│-- settings.gradle.kts
│-- local.properties
```

## Dependencies
The project uses the following dependencies:
```kotlin
// build.gradle.kts
dependencies {
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("com.google.android.material:material:1.5.0")
}
```

## Configuration Files
### `gradle.properties`
```properties
# Project-wide Gradle settings.
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
android.useAndroidX=true
android.nonTransitiveRClass=true
```

### `local.properties`
```properties
# Location of the SDK. This is automatically generated.
sdk.dir=C:\Users\atmiya\AppData\Local\Android\Sdk
```

## How to Build and Run
1. Open the project in **Android Studio**.
2. Ensure **Gradle Sync** completes successfully.
3. Connect an Android device or use an emulator.
4. Click on **Run** ▶ to build and deploy the app.

## Features
- Add a new task
- Display all tasks
- Delete a task
- Update a task

## License
This project is licensed under the MIT License.
