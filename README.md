# Presence Cache Android

A small Android helper for maintaining bounded, app-private presence snapshots.

## Usage

```java
PresenceCache cache = PresenceCache.create(context);
cache.put("member-42", "online");
String state = cache.get("member-42");
```

The cache stores only values explicitly supplied by the host application.

## Build

```bash
./gradlew :presence-cache:assembleRelease
```

