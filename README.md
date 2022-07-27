# droidcon KE 22 🔥🔨

Android app for the 3rd Android Developer conference- droidcon to be held in Nairobi from November
16-18th 2022.

This project is the Android app for the conference. The app supports devices running Android 5.0+,
and is optimized for phones and tablets of all shapes and sizes.

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

## Designs

This is the link to the app designs:  
Light Theme: https://xd.adobe.com/view/dd5d0245-b92b-4678-9d4a-48b3a6f48191-880e/  
Dark Theme: https://xd.adobe.com/view/5ec235b6-c3c6-49a9-b783-1f1303deb1a8-0b91/

## Contributing

Contributions are always welcome!

See [`CONTRIBUTING.md`](CONTRIBUTING.md) for ways to get started.

## Contributors

We would endlessly like to thank the following contributors

<!-- readme: contributors -start -->
<table>
<tr>
    <td align="center">
        <a href="https://github.com/jumaallan">
            <img src="https://avatars.githubusercontent.com/u/25085146?v=4" width="100;" alt="jumaallan"/>
            <br />
            <sub><b>Juma Allan</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/chepsi">
            <img src="https://avatars.githubusercontent.com/u/61404564?v=4" width="100;" alt="chepsi"/>
            <br />
            <sub><b>Evans Chepsiror</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/wangerekaharun">
            <img src="https://avatars.githubusercontent.com/u/15122455?v=4" width="100;" alt="wangerekaharun"/>
            <br />
            <sub><b>Harun Wangereka</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/gissilali">
            <img src="https://avatars.githubusercontent.com/u/13868653?v=4" width="100;" alt="gissilali"/>
            <br />
            <sub><b>Gibson Silali</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/Kagiri11">
            <img src="https://avatars.githubusercontent.com/u/59829833?v=4" width="100;" alt="Kagiri11"/>
            <br />
            <sub><b>Kagiri</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/keithchad">
            <img src="https://avatars.githubusercontent.com/u/63049827?v=4" width="100;" alt="keithchad"/>
            <br />
            <sub><b>Keith Chad</b></sub>
        </a>
    </td></tr>
<tr>
    <td align="center">
        <a href="https://github.com/michaelbukachi">
            <img src="https://avatars.githubusercontent.com/u/10145850?v=4" width="100;" alt="michaelbukachi"/>
            <br />
            <sub><b>Michael Bukachi</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/kibettheophilus">
            <img src="https://avatars.githubusercontent.com/u/61080898?v=4" width="100;" alt="kibettheophilus"/>
            <br />
            <sub><b>Kibet Theo</b></sub>
        </a>
    </td>
    <td align="center">
        <a href="https://github.com/MamboBryan">
            <img src="https://avatars.githubusercontent.com/u/40160345?v=4" width="100;" alt="MamboBryan"/>
            <br />
            <sub><b>Mambo Bryan</b></sub>
        </a>
    </td></tr>
</table>
<!-- readme: contributors -end -->
