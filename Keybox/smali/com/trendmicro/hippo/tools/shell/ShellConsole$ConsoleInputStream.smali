.class Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;
.super Ljava/io/InputStream;
.source "ShellConsole.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/trendmicro/hippo/tools/shell/ShellConsole;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ConsoleInputStream"
.end annotation


# static fields
.field private static final EMPTY:[B


# instance fields
.field private atEOF:Z

.field private buffer:[B

.field private final console:Lcom/trendmicro/hippo/tools/shell/ShellConsole;

.field private final cs:Ljava/nio/charset/Charset;

.field private cursor:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 193
    const/4 v0, 0x0

    new-array v0, v0, [B

    sput-object v0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->EMPTY:[B

    return-void
.end method

.method public constructor <init>(Lcom/trendmicro/hippo/tools/shell/ShellConsole;Ljava/nio/charset/Charset;)V
    .locals 1
    .param p1, "console"    # Lcom/trendmicro/hippo/tools/shell/ShellConsole;
    .param p2, "cs"    # Ljava/nio/charset/Charset;

    .line 200
    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    .line 196
    sget-object v0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->EMPTY:[B

    iput-object v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    .line 197
    const/4 v0, -0x1

    iput v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    .line 198
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->atEOF:Z

    .line 201
    iput-object p1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->console:Lcom/trendmicro/hippo/tools/shell/ShellConsole;

    .line 202
    iput-object p2, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cs:Ljava/nio/charset/Charset;

    .line 203
    return-void
.end method

.method private ensureInput()Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 242
    iget-boolean v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->atEOF:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 243
    return v1

    .line 245
    :cond_0
    iget v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    const/4 v2, 0x1

    if-ltz v0, :cond_1

    iget-object v3, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    array-length v3, v3

    if-le v0, v3, :cond_3

    .line 246
    :cond_1
    invoke-direct {p0}, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->readNextLine()I

    move-result v0

    const/4 v3, -0x1

    if-ne v0, v3, :cond_2

    .line 247
    iput-boolean v2, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->atEOF:Z

    .line 248
    return v1

    .line 250
    :cond_2
    iput v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    .line 252
    :cond_3
    return v2
.end method

.method private readNextLine()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 256
    iget-object v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->console:Lcom/trendmicro/hippo/tools/shell/ShellConsole;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/trendmicro/hippo/tools/shell/ShellConsole;->readLine(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 257
    .local v0, "line":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 258
    iget-object v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cs:Ljava/nio/charset/Charset;

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    iput-object v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    .line 259
    array-length v1, v1

    return v1

    .line 261
    :cond_0
    sget-object v1, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->EMPTY:[B

    iput-object v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    .line 262
    const/4 v1, -0x1

    return v1
.end method


# virtual methods
.method public declared-synchronized read()I
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    monitor-enter p0

    .line 231
    :try_start_0
    invoke-direct {p0}, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->ensureInput()Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 232
    const/4 v0, -0x1

    monitor-exit p0

    return v0

    .line 234
    :cond_0
    :try_start_1
    iget v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    iget-object v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    array-length v1, v1

    if-ne v0, v1, :cond_1

    .line 235
    iget v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 236
    const/16 v0, 0xa

    monitor-exit p0

    return v0

    .line 238
    .end local p0    # "this":Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;
    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    iget v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    aget-byte v0, v0, v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return v0

    .line 230
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized read([BII)I
    .locals 5
    .param p1, "b"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    monitor-enter p0

    .line 208
    if-eqz p1, :cond_5

    .line 210
    if-ltz p2, :cond_4

    if-ltz p3, :cond_4

    :try_start_0
    array-length v0, p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    sub-int/2addr v0, p2

    if-gt p3, v0, :cond_4

    .line 212
    if-nez p3, :cond_0

    .line 213
    const/4 v0, 0x0

    monitor-exit p0

    return v0

    .line 215
    :cond_0
    :try_start_1
    invoke-direct {p0}, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->ensureInput()Z

    move-result v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v0, :cond_1

    .line 216
    const/4 v0, -0x1

    monitor-exit p0

    return v0

    .line 218
    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    array-length v0, v0

    iget v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    sub-int/2addr v0, v1

    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 219
    .local v0, "n":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 220
    add-int v2, p2, v1

    iget-object v3, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->buffer:[B

    iget v4, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    add-int/2addr v4, v1

    aget-byte v3, v3, v4

    aput-byte v3, p1, v2

    .line 219
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 222
    .end local v1    # "i":I
    .end local p0    # "this":Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;
    :cond_2
    if-ge v0, p3, :cond_3

    .line 223
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "n":I
    .local v1, "n":I
    add-int/2addr v0, p2

    const/16 v2, 0xa

    aput-byte v2, p1, v0

    move v0, v1

    .line 225
    .end local v1    # "n":I
    .restart local v0    # "n":I
    :cond_3
    iget v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I

    add-int/2addr v1, v0

    iput v1, p0, Lcom/trendmicro/hippo/tools/shell/ShellConsole$ConsoleInputStream;->cursor:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 226
    monitor-exit p0

    return v0

    .line 211
    .end local v0    # "n":I
    :cond_4
    :try_start_3
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 209
    :cond_5
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 207
    .end local p1    # "b":[B
    .end local p2    # "off":I
    .end local p3    # "len":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
