#!/bin/sh

cd ~/apt

reprepro removefilter intechos 'Section'
sync
reprepro -b . includedeb intechos ~/intech/INTechOS/poky/build/tmp/deploy/deb/cortexa9hf-neon/*.deb
reprepro -b . includedeb intechos ~/intech/INTechOS/poky/build/tmp/deploy/deb/cortexa9hf-neon-mx6qdl/*.deb
reprepro -b . includedeb intechos ~/intech/INTechOS/poky/build/tmp/deploy/deb/all/*.deb
reprepro -b . includedeb intechos ~/intech/INTechOS/poky/build/tmp/deploy/deb/udooqdl/*.deb 
sync
