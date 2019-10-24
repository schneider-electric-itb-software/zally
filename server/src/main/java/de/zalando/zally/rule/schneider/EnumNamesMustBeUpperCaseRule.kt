package de.zalando.zally.rule.schneider

import com.typesafe.config.Config
import de.zalando.zally.rule.CaseChecker
import de.zalando.zally.rule.api.*
import de.zalando.zally.rule.zalando.ZalandoRuleSet;

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
    fun checkEnumNames(context:Context): List<Violation> =
        checker.checkEnumValues(context).map { Violation(description, it.pointer) }

}
