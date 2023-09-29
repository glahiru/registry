# Interview Case: People Registry
One of our clients has requested a proof of concept (POC) for a REST
service to replace their legacy backend for their people registry
system. The POC should allow users to save and retrieve information
about a person using their social security number as the identifier.
For each person, the service should store their name, the name of
their spouse (if applicable), and the name and age of their children.
The client also requested an endpoint that returns the name of the
oldest child for a given person, along with the person's social
security number. The number of stored persons is low, and it is
acceptable to lose data on restarts.
Your task is to create the domain model and functionality to save and
retrieve persons. You should assume that another team member will
build the REST application framework and handle JSON serialization.
The other team member is a junior and may require your advice on
naming and design of endpoints.
Please note that you should not submit a complete Spring application
or rely on any external dependencies except for the Java SDK and
possibly a test framework. You should only submit the necessary code
to implement the domain model and the functionality to save and
retrieve persons. You should aim for production-ready code where it
makes sense but stick to a minimal viable solution.
Please document any assumptions you make, and do not spend more than
an hour on this task, as the client will not pay for your time.
Once you have completed the code, please submit it before the
interview. You can attach the files in a mail or send a link to a
public git repository.

# People Registry

This is a people registry implementation (POC) to store People and retrieve people by their ID. Current implementation is using the social security as their ID.
Currently it contains only the domain model with basic functionality (for example updates are not yet supported).

Following are the assumptions of the current implementation,

- Number of entries in the system is fairly small so the system is not optimized to use minimum memory.
- Social security number contains the United states social security number.
- No frameworks are used other than for testing.
- All data will be lost during a server restart because data is all in memory.
- Used a plugin to generate some Builder logic but it can be done in a better way that we support setting values in any order. Current approach only support setting values in a strict order. We should revisit this and do a proper Builder implementation. This was mainly done to save time and move fairly quickly.
- When adding or querying by SSN we should put the SSN in the request body rather than putting it in the query parameter.
- Depending on the sensitivity of the social security number, we can later decide weather to store the hashed version or the raw values.
