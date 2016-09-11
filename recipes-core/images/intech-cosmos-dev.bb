require intech-cosmos.bb

IMAGE_FEATURES += " \
	tools-sdk \
	tools-debug \
	package-management \
	dev-pkgs \
	ptest-pkgs \
"

JAVA += " \
	openjdk-8 \
"

IMAGE_INSTALL += " \
	gcc \
	cmake \
	vim \
	nano \
	git \
	subversion \
"