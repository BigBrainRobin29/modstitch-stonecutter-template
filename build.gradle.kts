plugins {
    id("dev.isxander.modstitch.base") version "0.8.4"
}

fun prop(name: String, consumer: (prop: String) -> Unit) {
    (findProperty(name) as? String?)
        ?.let(consumer)
}

modstitch {
    prop("deps.minecraft") { minecraftVersion = it }

    parchment {
        prop("parchment.version") { mappingsVersion = it }
        prop("parchment.minecraft") { minecraftVersion = it }
    }

    metadata {
        modId = "template"
        modName = "Template Mod"
        modVersion = "${property("mod.version")}+${stonecutter.current.project}"
        modDescription = "Modstitch x Stonecutter mod template"
        modLicense = "CC0-1.0"
        modGroup = "dev.bigbrainrobin29"
        modAuthor = "BigBrainRobin29"

        replacementProperties.put("mod_modrinth", "https://modrinth.com/mod/template")
        replacementProperties.put("mod_sources", "https://github.com/BigBrainRobin29/modstitch-stonecutter-template")
        replacementProperties.put("mod_issues", "https://github.com/BigBrainRobin29/modstitch-stonecutter-template/issues")
        replacementProperties.put("minecraft", property("deps.minecraft.constraint") as String)
    }

    loom {
        fabricLoaderVersion = "0.18.5"
    }

    moddevgradle {
        prop("deps.neoforge") { neoForgeVersion = it }

        defaultRuns()

        configureNeoForge {
            runs.all {
                disableIdeRun()
            }
        }
    }

    mixin {
        addMixinsToModManifest = true

        configs.register("template")
    }
}

stonecutter {
    var loader: String = name.split("-")[1]

    constants.match(
        loader,
        "fabric",
        "neoforge"
    )
}

dependencies {
    modstitch.loom {
        // modstitchModImplementation("net.fabricmc.fabric-api:fabric-api:0.112.0+1.21.4")
    }
}

tasks.register<Copy>("buildAndCollect") {
    group = "build"
    from(modstitch.finalJarTask.map { it.archiveFile } )
    into(rootProject.layout.buildDirectory.dir("collected/${project.property("mod.version")}"))
    dependsOn("build")
}