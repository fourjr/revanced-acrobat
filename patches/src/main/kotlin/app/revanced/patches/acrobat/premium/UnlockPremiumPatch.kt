package app.revanced.patches.acrobat.premium

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.bytecodePatch

@Suppress("unused")
val unlockPremiumPatch = bytecodePatch(
    name = "Unlock premium",
) {
    compatibleWith("com.adobe.reader")

    val hasPurchasedMatch by hasPurchasedFingerprint()

    execute {
        // Set hasPremium = true.
        hasPurchasedMatch.mutableMethod.replaceInstruction(8, "const/4 v0, 0x1")
    }
}