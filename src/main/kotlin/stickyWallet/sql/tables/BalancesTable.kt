package stickyWallet.sql.tables

import org.jetbrains.exposed.sql.Table
import stickyWallet.configs.PluginConfiguration
import stickyWallet.sql.PostgresDecimal
import java.math.BigDecimal

object BalancesTable : Table(
    PluginConfiguration.StorageSettings.storageTablePrefix + "_balances"
) {
    val accountID = varchar("account_id", 255)
    val currencyID = varchar("currency_id", 255)
    val balance = registerColumn<BigDecimal>("balance", PostgresDecimal())

    override val primaryKey = PrimaryKey(accountID, currencyID)
}
