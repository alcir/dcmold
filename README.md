dcmold
======

= Introduction =

This tool can be used to query a PACS server and get a list of studies between a date range.
It is based on dcm4che toolkit.

= Details =

There are two kind of result:
0, long: patient name, modality, number of series and instances, study date, suid
1, short: only suid, useful for machine parsing (like a script invoking twiddle.sh)

== Usage examples ==

`./dcmold/bin/dcmold.sh AETITLE@192.168.56.101:11112 "US" 20000101-20090101 0` <BR>
`./dcmold/bin/dcmold.sh AETITLE@192.168.56.101:11112 "*" 20080101-20090101 1`

`./dcmold/bin/dcmold.sh AETITLE@192.168.56.101:11112 "MR" 20080101-20090101 1 > file.txt`

Using the last example, you can run ./dcmold/bin/twiddlerm.sh to invoke twiddle and, i.e. remove from the PACS server all the sutdies in the 20080101-20090101 date range.
Remeber to edit twiddlerm.sh setting your parameters and the dcm4chee service to invoke.

= Requirements =

It uses the following jar files

commons-cli-1.2.jar
commons-collections-3.2.1.jar
commons-lang3-3.1.jar
dcm4che-core-2.0.26.jar
dcm4che-iod-2.0.26.jar
dcm4che-net-2.0.26.jar
dcm4che-tool-dcmqr-2.0.26.jar
dcmold.jar
log4j-1.2.16.jar
mail.jar
slf4j-api-1.6.1.jar
slf4j-log4j12-1.6.1.jar


Works only with java 1.6, java 1.7 not tested.
