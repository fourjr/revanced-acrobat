package app.revanced.patches.acrobat.premium

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.acrobat.premium.fingerprints.HasPurchasedFingerprint

@Patch(
    name = "Unlock premium for acrobat",
    compatiblePackages = [CompatiblePackage("com.adobe.reader")]
)
@Suppress("unused")
object UnlockPremiumPatch : BytecodePatch(
    setOf(HasPurchasedFingerprint)
){
    override fun execute(context: BytecodeContext) {
        // Set hasPremium = true using smaliInstructions
        HasPurchasedFingerprint.result?.mutableMethod?.replaceInstruction(2, "const/4 v2, 0x1")
            ?: throw IllegalArgumentException()
    }
}