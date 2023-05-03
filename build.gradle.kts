plugins {
	application
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework:spring-context:6.0.8")

	testImplementation("org.mockito:mockito-core:5.3.1")
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

application {
	mainClass.set("demo.App")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
