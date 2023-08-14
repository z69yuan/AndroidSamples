package com.beancurd.kadvance

/**
 *
 * 委托类
 * @author  beancurdv on 2023/8/11
 */

interface DB {
    fun save()
}

class SqlDB : DB {
    override fun save() {
        println("save to sql")
    }
}

class MySqlDB : DB {
    override fun save() {
        println("save to mysql")
    }
}

class OracleDB : DB {
    override fun save() {
        println("save to oracle")
    }
}

//@Metadata(
//    mv = {1, 8, 0},
//    k = 1,
//    d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0006"},
//    d2 = {"Lcom/beancurd/kadvance/CreateDbAction;", "Lcom/beancurd/kadvance/DB;", "db", "(Lcom/beancurd/kadvance/DB;)V", "save", "", "kadvance_debug"}
//)
//public final class CreateDbAction implements DB {
//// $FF: synthetic field
//    private final DB $$delegate_0;
//
//    public CreateDbAction(@NotNull DB db) {
//        Intrinsics.checkNotNullParameter(db, "db");
//        super();
//        this.$$delegate_0 = db;
//    }
//
//    public void save() {
//        this.$$delegate_0.save();
//    }
//}
class CreateDbAction(val db: DB) : DB by db

class CreateDbActionV2(db: DB,keyboardUsb: KeyboardUsb) : IUsb by keyboardUsb, DB by db

fun main() {
    CreateDbAction(SqlDB()).save()
    CreateDbAction(MySqlDB()).save()
    CreateDbAction(OracleDB()).save()
}




interface IPlugin {
    fun doPlugin()
}

interface IUsb : IPlugin {
    fun doUsb()
}

interface ITypeC : IPlugin {
    fun doType()
}


class KeyboardUsb : IUsb {
    override fun doPlugin() {
        println("doPlugin")
    }

    override fun doUsb() {
        println("doUsb")
    }
}


class KeyboardTypeC : ITypeC {
    override fun doType() {
        println("doType")
    }

    override fun doPlugin() {
        println("doPlugin")
    }

}

/**
 * 适配器模式
 */
class LogitechKeyboard : ITypeC by KeyboardTypeC() {
    fun doLogitech() {
        doType()
    }
}