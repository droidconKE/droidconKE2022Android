# droidcon KE 22 🔥🔨

Android app for the 3rd Android Developer conference- droidcon to be held in Nairobi from November 16-18th 2022.

This project is the Android app for the conference. The app supports devices running Android 5.0+, and is optimized for phones and tablets of all shapes and sizes.


## Dependencies
1. Jetpack Compose
2. Coroutines - For Concurrency and Asynchronous tasks
3. Ktor - For network requests
4. Hilt - For Dependency Injection
5. Crashlytics
6. Coil - For Image Loading and Caching
7. Lint Checks - [Ktlint](https://ktlint.github.io/)
## Architecture
The proposed architecture is as follows;

### Data
This layer will include;
1. Network Calls
2. Caching
3. Storing and fetching Preferences.
4. The repository implementation
5. The relevant data models
6. Relevant Mappers

### Domain
This layer will contain;
1. The Usecase
2. The repository
3. The relevant domain models.

### Presentation
1. View
2. ViewModels
3. Relevant Mappers
4. Relevant Models.


## Features
App will have the following features:
- Sessions
- Feed
- About
- Home
- Speakers
- Sponsors
- Authentication
- Feedback

## Contributing

Contributions are always welcome!

See [`contributing.md`](contributing.md) for ways to get started.

## Designs
This is the link to the app designs:  
Light Theme: https://xd.adobe.com/view/dd5d0245-b92b-4678-9d4a-48b3a6f48191-880e/  
Dark Theme: https://xd.adobe.com/view/5ec235b6-c3c6-49a9-b783-1f1303deb1a8-0b91/  
