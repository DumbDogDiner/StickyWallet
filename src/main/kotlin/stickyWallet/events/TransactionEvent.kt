package stickyWallet.events

import stickyWallet.accounts.Account
import stickyWallet.currency.Currency
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import stickyWallet.utils.TransactionType

class TransactionEvent(
    val currency: Currency,
    val account: Account,
    val amount: Double,
    val type: TransactionType
): Event(), Cancellable {

    private val handlerList = HandlerList()
    private var cancel: Boolean = false

    override fun getHandlers() = handlerList

    override fun setCancelled(cancel1: Boolean) {
        cancel = cancel1
    }

    override fun isCancelled() = cancel

    val formattedAmount
        get() = currency.format(amount)

}