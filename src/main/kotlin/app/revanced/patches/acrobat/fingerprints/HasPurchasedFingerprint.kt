package app.revanced.patches.acrobat.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal object HasPurchasedFingerprint : MethodFingerprint(
    returnType = "Z",
    accessFlags = AccessFlags.PRIVATE or AccessFlags.FINAL,
    strings = listOf("isPurchaseDoneRecently = true, access platform profile present? = "),
    opcodes = listOf(
        Opcode.SGET_OBJECT,
        Opcode.CONST_4,
        Opcode.CONST_4,
        Opcode.CONST_4,
    )
)