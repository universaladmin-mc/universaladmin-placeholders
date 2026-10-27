<img src="assets/icon.png" alt="UniversalAdmin Placeholders" width="96" align="right">

# UniversalAdmin Placeholders

[![Build](https://github.com/universaladmin-mc/universaladmin-placeholders/actions/workflows/build.yml/badge.svg)](https://github.com/universaladmin-mc/universaladmin-placeholders/actions/workflows/build.yml)
[![License](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](LICENSE)
[![Modrinth](https://img.shields.io/badge/Modrinth-universaladmin-placeholders-00AF5C)](https://modrinth.com/plugin/universaladmin-placeholders)

PlaceholderAPI placeholders for UniversalAdmin: the online count without vanished players, mutes, warnings, open reports, maintenance and network counts.

An official extension for [UniversalAdmin](https://github.com/universaladmin-mc/UniversalAdmin),
the free all-in-one admin plugin for Paper.

- **Documentation:** [https://universaladmin-mc.github.io/UniversalAdmin/extensions/placeholderapi/](https://universaladmin-mc.github.io/UniversalAdmin/extensions/placeholderapi/)
- **Download:** [Modrinth](https://modrinth.com/plugin/universaladmin-placeholders) or the
  [releases](https://github.com/universaladmin-mc/universaladmin-placeholders/releases) - put the
  jar next to UniversalAdmin in `plugins/`. UniversalAdmin's update check
  covers this extension too.
- **Bugs and ideas:** [UniversalAdmin's issues](https://github.com/universaladmin-mc/UniversalAdmin/issues)

## Building

```bash
./gradlew build   # build/libs/universaladmin-placeholderapi-<version>.jar
```

It compiles against the UniversalAdmin release named in `gradle.properties`
(from Modrinth's Maven repository); `-PuniversaladminJar=<path>` builds
against a local UniversalAdmin build instead. Releases: bump `version` in
`build.gradle.kts`, add a `CHANGELOG.md` section, tag `v<version>` - the
release workflow publishes to GitHub and Modrinth.

## License

[GNU GPL v3.0 or later](LICENSE).
