rootProject.name = "revanced-acrobat"

buildCache {
    local {
        isEnabled = "CI" !in System.getenv()
    }
}
