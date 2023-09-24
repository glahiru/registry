# People Registry

This is a people registry implementation (POC) to store People and retrieve people by their ID. Current implementation is using the social security as their ID.
Currently it contains only the domain model with basic functionality (for example updates are not yet supported).

Following are the assumptions of the current implementation,

- Number of entries in the system is fairly small so the system is not optimized to use minimum memory.
- Social security number contains the United states social security number.
- No frameworks are used other than for testing.
- All data will be lost during a server restart because data is all in memory.
- Used a plugin to generate some Builder logic but it can be done in a better way that we support setting values in any order. Current approach only support setting values in a strict order. We should revisit this and do a proper Builder implementation. This was mainly done to save time and move fairly quickly.
