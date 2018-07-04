import fileinput
import sys

for line in fileinput.input("../meta-intechos-udooqdl/recipes-multimedia/motordaemon/motordaemon_0.2.bb", inplace=True, backup='.bak'):
    if "PR = \"r" in line:
        print "PR = \"r" + str(int(line[7:(len(line)-2)])+1)+"\""
    else:
        sys.stdout.write(line)

fileinput.close()
