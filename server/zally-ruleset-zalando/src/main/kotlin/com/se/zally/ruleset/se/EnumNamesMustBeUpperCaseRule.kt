package com.se.zally.ruleset.se

import com.typesafe.config.Config
import de.zalando.zally.core.CaseChecker
import de.zalando.zally.rule.api.Context
import de.zalando.zally.rule.api.Rule
import de.zalando.zally.rule.api.Severity
import de.zalando.zally.rule.api.Violation
import de.zalando.zally.rule.api.Check
import de.zalando.zally.ruleset.zalando.ZalandoRuleSet

@Rule(
        ruleSet = ZalandoRuleSet::class,
        id = "501",
        severity = Severity.MUST,
        title = "Enum names Must be SCREAMING_SNAKE_CASE"
)
class EnumNamesMustBeUpperCaseRule(config: Config) {

    private val description = "Enum name has to be SCREAMING_SNAKE_CASE"

    private val checker = CaseChecker.load(config)

    @Check(severity = Severity.MUST)
    fun checkEnumNames(context: Context): List<Violation> =
        checker.checkEnumValues(context).map { Violation(description, it.pointer) }
}
