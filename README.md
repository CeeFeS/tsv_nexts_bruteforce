# tsv_nexts_bruteforce
Teamspeak Viewer Burteforce uses a Backdoor of Teamspeak Provider <nexteamspeak.de> to detecting all running servers on it. The program was written in Java and can be started with log files that allow you to find IPs from the provider's Teamspeak servers. tsv_nexts_bruteforce also creates an unofficial list of the reachable servers.

## Requirements
- at least: Java version 1.8

## Parameters

```
java -jar tsv_bruteforce_1.0.jar <Start-IPv4> <log/notlog>
```
- example: `java -jar tsv_bruteforce_1.0.jar 225.134.0.0 log`

