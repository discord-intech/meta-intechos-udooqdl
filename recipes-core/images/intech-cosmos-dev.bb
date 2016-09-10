require intech-cosmos.bb

IMAGE_FEATURES += "tools-sdk"

JAVA += " \
	openjdk-8 \
"

IMAGE_INSTALL += " \
	gcc \
	cmake \
"
