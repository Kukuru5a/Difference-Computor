install:
	./gradlew installDist

run:
	./gradlew run

run-dist:
	./build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

clean:
	./gradlew clean

update-deps:
		./gradlew useLatestVersions


build-run: build run

.PHONY: build
