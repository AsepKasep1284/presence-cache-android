# Presence Cache Android

A small Android helper for maintaining bounded, app-private presence snapshots.

Current stable release: `1.1.0`

## Usage

```java
PresenceCache cache = PresenceCache.create(context);
cache.put("member-42", "online");
String state = cache.get("member-42");
```

The cache stores only values explicitly supplied by the host application.

Applications remain responsible for deciding when values are written or
removed. The library does not register startup components or network services.

## Build

```bash
./gradlew :presence-cache:assembleRelease
```


