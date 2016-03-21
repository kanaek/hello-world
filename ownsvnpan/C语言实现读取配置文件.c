//-----------------------------------read_conf.h

/*
�����������������Ƕ��ʽӦ����������ļ������治ͬ�����Ǻܳ�����Ӧ�á�
�����C���������������ļ�����һ����ʵ�ʵ�Ӧ�á�
��Ҫʹ�ú���ָ�룬�����õ��ַ�������,
����ͨ�����岻ͬstatic CONF_ITEM conf_list[]��ʵ�ֶ���ͬ���ò���
*/

//----------------------------------------------------------------------------
//
// FILE NAME                                      VERSION
// read_conf.c                                      1.0
//
// DESCRIPTION
//     Generally get some variable settings from configure file
/*
  ���������ļ��Ĵ��룬ÿһ�в�����1024�ַ��� 
  1.��ע��,��#��ͷ�����׿ո�Ҫ����
  2.һ������ռһ�У��������ʽ
      ������ = ����ֵ
      ������= ��Ҳ�Ϸ�. =�������޿ո�Ӱ������ֵ����Ϊ�ո�
  
  3.д�������һ��֪����Ҫ��ȡ��һЩ�������Լ������ĺ���͸�ʽ
  4.û�г��ֱ����Զ�����Ĭ��ֵ
  5.����ǰ��˳��Ӱ�����ս���������ñ������Ե���˳��.

  #this is a commant 
  set = 1 
  ipaddr = 192.168.0.1 
  host=developer.com
  
��չ��1.���Ӷ�֧�� [network]
      2.����������ĳһ���ε�
      3.û������ĳ�εı����Զ����ȫ��
  ���޷ֶε����
  [com1] 
  baudrate=115200
  stopbit = 1
  ...
  [com2] 
  baudrate=9600
  stopbit=2
  ...
  ...
*/
// DEPENDENCIES
//      stdio.h
//      stdlib.h
//      string.h
//
// HISTORY:
//  2013.3.15      Arthur Zhu      Initial begin
//----------------------------------------------------------------------------

#ifndef __READ_CONF_FILE_H__
#define __READ_CONF_FILE_H__

#ifdef __cplusplus
extern "C" {
#endif

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//#define __CONF_DEBUG__
//#define __CONF_FIELD_SUPPORT__

#define LINE_SIZE   1024

#define COMMENT_CHARACTER   '#'
#define ASSIGN_CHARACTER    '='
#ifdef __CONF_FIELD_SUPPORT__
#define SEG_BEGIN_CHARACTER '['
#define SEG_END_CHARACTER   ']'
#define FIELD_ALL           "all"
#endif

#define CONF_LINE_FIELD     0x00 /* ���ö���*/
#define CONF_LINE_CONFIGURE 0x01 /* ��������*/
#define CONF_LINE_DEFAULT   0x02 /* ������Ĭ��*/
#define CONF_LINE_COMMENT   0x03 /* ע��*/
#define CONF_LINE_EMPTY     0x04 /* ����*/
#define CONF_LINE_UNSUPPORT 0x05 /* ��֧�ֵı���*/
#define CONF_LINE_UNKNOW    0x06 /* �޷�ʶ����У���"=" */

//enum �൱��ȡֵ��Χ���޵�һ������
typedef enum conf_val_type {
   conf_integer = 0,
   conf_string  = 2,
   conf_ipaddr  = 4, 
} CONF_VAL_TYPE;

typedef struct conf_item{
#ifdef __CONF_FIELD_SUPPORT__
    char * field;               // �������� 
#endif
    char * name;                // ����������
    int    val_type;            // ���õ����ͣ��������ַ�����IP��ַ ...
    char * val_default;         // ����Ĭ��ֵ
    char * value;               // ���õ�ǰֵ
    int (* conf_handle)(void * conf_result, void * p_conf_item);
} CONF_ITEM;

#ifdef __CONF_FIELD_SUPPORT__
extern CONF_ITEM * find_conf_item(CONF_ITEM * p_conf_list, char * conf_name, char * conf_field);
extern int parse_conf_line(CONF_ITEM * p_conf_list, char * line_str, char * conf_field);
#else
extern CONF_ITEM * find_conf_item(CONF_ITEM * p_conf_list, char * conf_name);
extern int parse_conf_line(CONF_ITEM * p_conf_list, char * line_str);
#endif 
extern int parse_conf_file(CONF_ITEM * p_conf_list, char * conf_file_name);
extern int conf_parse_integer(void * conf_result, void * p_conf_item);
extern int conf_parse_string(void * conf_result, void * p_conf_item);
extern int conf_parse_ipaddr(void * conf_result, void * p_conf_item);
extern int free_conf_value(CONF_ITEM * p_conf_list);

/*
static CONF_ITEM conf_list[] = {              // �������б�ʾ�� 
#ifdef __CONF_FIELD_SUPPORT__
  {"test", "result_max",     conf_integer, "19",         NULL, conf_parse_integer },
  {FIELD_ALL, "num_max",     conf_integer, "9",          NULL, conf_parse_integer },
  {FIELD_ALL, "start_num",   conf_integer, "1",          NULL, conf_parse_integer },
  {FIELD_ALL, "equ_num_max", conf_integer, "20",         NULL, conf_parse_integer },
//  {FIELD_ALL, "ipaddr",      conf_ipaddr, "192.168.1.1", NULL, conf_parse_ipaddr }, 
//  {FIELD_ALL, "host",        conf_string, "hxy",         NULL, conf_parse_string }, 
  {NULL, NULL,               conf_integer, 0,            NULL, NULL}, //������־
#else
  {"result_max",    conf_integer, "19",         NULL, conf_parse_integer },
  {"num_max",       conf_integer, "9",          NULL, conf_parse_integer },
  {"start_num",     conf_integer, "1",          NULL, conf_parse_integer },
  {"equ_num_max",   conf_integer, "20",         NULL, conf_parse_integer },
  {"ipaddr",        conf_ipaddr, "192.168.1.1", NULL, conf_parse_ipaddr }, 
  {"host",          conf_string, "hxy",         NULL, conf_parse_string }, 
  {NULL,            conf_integer, 0,            NULL, NULL}, //������־
#endif
};
*/

#ifdef __cplusplus
}
#endif

#endif      // end of __READ_CONF_FILE_H__




//-----------------------------------read_conf.c


/*
�����������������Ƕ��ʽӦ����������ļ������治ͬ�����Ǻܳ�����Ӧ�á�
�����C���������������ļ�����һ����ʵ�ʵ�Ӧ�á�
��Ҫʹ�ú���ָ�룬�����õ��ַ�������,
����ͨ�����岻ͬstatic CONF_ITEM conf_list[]��ʵ�ֶ���ͬ���ò���
*/

//----------------------------------------------------------------------------
//
// FILE NAME                                      VERSION
// read_conf.c                                      1.0
//
// DESCRIPTION
//     Generally get some variable settings from configure file
/*
  ���������ļ��Ĵ��룬ÿһ�в�����1024�ַ��� 
  1.��ע��,��#��ͷ�����׿ո�Ҫ����
  2.һ������ռһ�У��������ʽ
      ������ = ����ֵ
      ������= ��Ҳ�Ϸ�. =�������޿ո�Ӱ������ֵ����Ϊ�ո�
  
  3.д�������һ��֪����Ҫ��ȡ��һЩ�������Լ������ĺ���͸�ʽ
  4.û�г��ֱ����Զ�����Ĭ��ֵ
  5.����ǰ��˳��Ӱ�����ս���������ñ������Ե���˳��.

  #this is a commant 
  set = 1 
  ipaddr = 192.168.0.1 
  host=developer.com
  
��չ��1.���Ӷ�֧�� [network]
      2.����������ĳһ���ε�
      3.û������ĳ�εı����Զ����ȫ��
  ���޷ֶε����
  [com1] 
  baudrate=115200
  stopbit = 1
  ...
  [com2] 
  baudrate=9600
  stopbit=2
  ...
  ...
*/
// DEPENDENCIES
//      stdio.h
//      stdlib.h
//      string.h
//
// HISTORY:
//  2013.3.15      Arthur Zhu      Initial begin
//----------------------------------------------------------------------------

#include "read_conf.h"

//----------------------------------------------------------------------------
// Function name    : find_conf_item
// Description      : To find the variable to be configured, or return NULL
//                    check the configure item struct list whether is end with NULL pointer
// DEPENDENCIES     : string
// Return type      : CONF_ITEM *
// Argument         : CONF_ITEM * p_conf_list: configure item struct list
//                    char * conf_name: variable name
//----------------------------------------------------------------------------
#ifdef __CONF_FIELD_SUPPORT__
CONF_ITEM * find_conf_item(CONF_ITEM * p_conf_list, char * conf_name, char * conf_field)
#else
CONF_ITEM * find_conf_item(CONF_ITEM * p_conf_list, char * conf_name)
#endif
{
    CONF_ITEM * p_find = NULL;

    for(p_find = p_conf_list; p_find->name != NULL; p_find++)
    {
        if ( (0 == strcmp(conf_name, p_find->name))
#ifdef __CONF_FIELD_SUPPORT__
          && (0 == strcmp(conf_field, p_find->field))
#endif
           )
            return p_find;
        else;
    }

    return NULL;                    // ��֧�ֵı�����
}

#ifdef __CONF_DEBUG__
//----------------------------------------------------------------------------
// Function name    : mgs_parse_conf_line
// Description      : output message to std device
// Return type      : int
// Argument         : int type : error type of parse_conf_line
//                    int line_no: line number
//----------------------------------------------------------------------------
int  mgs_parse_conf_line(int type, int line_no)
{
    //���������ļ���;
    switch(type)
    {
      default:
      case CONF_LINE_UNKNOW:
        printf("line %d: unknow\n", line_no);
        break;
      case CONF_LINE_EMPTY:
        printf("line %d: empty line\n", line_no);
        break; 
      case CONF_LINE_COMMENT:
        printf("line %d: comment\n", line_no); 
        break;
      case CONF_LINE_FIELD:
        printf("line %d: field change\n", line_no); 
        break;
      case CONF_LINE_CONFIGURE:
        printf("line %d: configured\n", line_no); 
        break;
      case CONF_LINE_UNSUPPORT:
        printf("line %d: unsupport\n", line_no); 
        break;
    }
    return (type);
}

//----------------------------------------------------------------------------
// Function name    : mgs_conf_list
// Description      : output settings to std device
// Return type      : int
// Argument         : CONF_ITEM * p_conf_list : variable pointer
//----------------------------------------------------------------------------
int mgs_conf_list(CONF_ITEM * p_conf_list)
{
    CONF_ITEM * p_item = NULL;

    for(p_item = p_conf_list; NULL != p_item->name; p_item++)
    {
        if ( NULL != p_item->value )
        {
#ifdef __CONF_FIELD_SUPPORT__
            printf("%s : %s = %s\n", p_item->field, p_item->name, p_item->value); 
#else
            printf("%s = %s\n", p_item->name, p_item->value); 
#endif
        }
        else
#ifdef __CONF_FIELD_SUPPORT__
            printf("%s : %s = %s\n", p_item->field, p_item->name, p_item->val_default); 
#else
            printf("%s = %s\n", p_item->name, p_item->val_default); 
#endif
    }

    return 0;
}
#endif // __CONF_DEBUG__

//----------------------------------------------------------------------------
// Function name    : parse_conf_line
// Description      : To parse one line of configure file, include 3 parts:
//                    skip comment, variable parse, configure value paese
// DEPENDENCIES     : stdlib, string, find_conf_item
//                    It must be compared with function "free_conf_value" to
//                    free the memory allocated here
// Return type      : int : error code
//                    CONF_LINE_CONFIGURE // configure ok
//                    CONF_LINE_DEFAULT   // use default configure
//                    CONF_LINE_COMMENT   // comment line
//                    CONF_LINE_EMPTY     // empty line
//                    CONF_LINE_UNSUPPORT // variable no supported
//                    CONF_LINE_UNKNOW    // line unknow, no '='
// Argument         : CONF_ITEM * p_conf_list: configure item struct list
//                    char * line_str: line char pointer
//----------------------------------------------------------------------------
#ifdef __CONF_FIELD_SUPPORT__
int parse_conf_line(CONF_ITEM * p_conf_list, char * line_str, char * conf_field)
#else
int parse_conf_line(CONF_ITEM * p_conf_list, char * line_str)
#endif
	{
    CONF_ITEM * p_conf_item;
    char * line_pos;
    char * conf_name;
    char * conf_value;
#ifdef __CONF_FIELD_SUPPORT__
    char   conf_field_line = 0;
#endif

    // skip comment 
    if ( NULL != (line_pos = strchr(line_str, COMMENT_CHARACTER)) )
        *line_pos = 0;
    else;

    // skip the front whitespace(include ' ', '\t', '\n')
	while ( isspace(*line_str) )
        line_str++;

    if ( '\0' == *line_str )
        return CONF_LINE_EMPTY;
    else;

#ifdef __CONF_FIELD_SUPPORT__
    if ( (SEG_BEGIN_CHARACTER == *line_str ) &&
	     (NULL != (conf_name = strchr(line_str, SEG_END_CHARACTER))) )
    {
        *conf_name = '\0';          // ȥ����β 
        conf_field_line = 1;
        line_str++;
        // skip the front whitespace(include ' ', '\t', '\n')
	    while ( isspace(*line_str) )
            line_str++;
        conf_name = line_str;       // ��ö��ַ�����ָ��
    }
    else
#endif
    conf_name = line_str;           // ������ַ�����ָ��
    // ����=, ��������Ϊ0, �������۷ֳ��������ͱ���ֵ��
    while ( !( ('\n' == *line_str) || ('\0' == *line_str) ||
               (ASSIGN_CHARACTER  == *line_str)           ) )
    {
        line_str++;
        *line_str = tolower(*line_str); // ˳��ѱ��������Сд
    }

#ifdef __CONF_FIELD_SUPPORT__
    if ( !conf_field_line  && (ASSIGN_CHARACTER != *line_str) )// ��ʾ��һ�в���[]�������Ƕ��� 
#else
    if ( ASSIGN_CHARACTER != *line_str )    // ��ʾ��һ��û�� =
#endif
        return CONF_LINE_UNKNOW;
    else;

    line_pos = line_str + 1;        // --��ʱ���浱ǰ�¸��ַ�ָ��
    do                              // �ص�������������ַ�(' ', '\t', '\n')
    {
        line_str--;
    } while ( isspace(*line_str) && (conf_name < line_str));
    *(line_str + 1) = '\0';

#ifdef __CONF_FIELD_SUPPORT__
    if (conf_field_line)            // field configure
    {
        if ('\0' == *conf_name)     // empty
            strcpy(conf_field, FIELD_ALL);
        else
            strcpy(conf_field, conf_name);
        return CONF_LINE_FIELD;
    }
    else
    {
#endif

    line_str = line_pos;            // --�ָ���ʱ����ָ��
    // skip whitespace(' ', '\t', '\n')
    while ( isspace(*line_str) )
        line_str++;

//    if ( '\0' == *line_str )
//        return CONF_LINE_NOVAL;

    conf_value = line_str;          // ���ֵ�ַ�����ָ��

    while ( '\0' != *line_str )
    {
        line_str++;
    }
    do                              // �ص�ֵ�ַ���������ַ�(' ', '\t', '\n')
    {
        line_str--;
    } while ( isspace(*line_str)  && (conf_value < line_str) );
    *(line_str + 1) = '\0';

    //���� conf_name �ǲ���ϵͳ֧�ֵ�������
#ifdef __CONF_FIELD_SUPPORT__
    p_conf_item = find_conf_item(p_conf_list, conf_name, conf_field);
#else
    p_conf_item = find_conf_item(p_conf_list, conf_name);
#endif

    if (NULL == p_conf_item)
        return CONF_LINE_UNSUPPORT;
    else;

    if ('\0' != *conf_value)
    {
        p_conf_item->value = (char *)malloc((strlen(conf_value) + 1) * sizeof(char));
        if (NULL != p_conf_item->value)
        {
            strcpy(p_conf_item->value, conf_value);
            return CONF_LINE_CONFIGURE;
        }
        else
        {
            printf ("[-] Not Enough Memory, '%s' use default value!\n", p_conf_item->name);
            return CONF_LINE_DEFAULT;
        }
    }
    else;

    return CONF_LINE_DEFAULT;
#ifdef __CONF_FIELD_SUPPORT__
    }
#endif
}

//----------------------------------------------------------------------------
// Function name    : parse_conf_file
// Description      : To parse the whole configure file line by line
// DEPENDENCIES     : stdio, parse_conf_line
// Return type      : int : error code
//                    CONF_LINE_CONFIGURE // configure ok
//                    CONF_LINE_DEFAULT   // use default configure
//                    CONF_LINE_COMMENT   // comment line
//                    CONF_LINE_EMPTY     // empty line
//                    CONF_LINE_UNSUPPORT // variable no supported
//                    CONF_LINE_UNKNOW    // line unknow, no '='
// Argument         : CONF_ITEM * p_conf_list: configure item struct list
//                    char * line_str: line char pointer
//----------------------------------------------------------------------------
int parse_conf_file(CONF_ITEM * p_conf_list, char * conf_file_name)
{
    char   line_str[LINE_SIZE];
#ifdef __CONF_FIELD_SUPPORT__
    char   conf_field[LINE_SIZE] = FIELD_ALL;
#endif
    FILE * fp_conf;
    int    parse_errno;
    int    line_no = 0;

#ifdef __CONF_DEBUG__
    printf("Default settings:\n");
    mgs_conf_list(p_conf_list);
#endif
    /* Read parameter from file. */
    if ( NULL == (fp_conf = fopen(conf_file_name, "r")) )
    {
        printf("[-] open %s failed.\n", conf_file_name);
        getchar();
        exit(1);
    }
    else
        printf ("The configure file %s is being read ...\n", conf_file_name);

    while ( NULL != fgets(line_str, LINE_SIZE, fp_conf) )
    {
        line_no++;
#ifdef __CONF_FIELD_SUPPORT__
        parse_errno = parse_conf_line(p_conf_list, line_str, conf_field);
#else
        parse_errno = parse_conf_line(p_conf_list, line_str);
#endif

#ifdef __CONF_DEBUG__
        mgs_parse_conf_line(parse_errno, line_no);
#else
        if ( ( CONF_LINE_UNSUPPORT == parse_errno ) ||
             ( CONF_LINE_UNKNOW    == parse_errno ) )
            printf("[-] Unknow or unsupported line %d.\n", line_no);
        else;
#endif
    }

#ifdef __CONF_DEBUG__
    printf("Configure settings:\n");
    mgs_conf_list(p_conf_list);
#endif
    fclose(fp_conf);
    printf("[+] Configure done.\n");
    return 0;
}

//----------------------------------------------------------------------------
// Function name    : conf_parse_integer
// Description      : parse the string varialbe to integer, equipped in CONF_ITEM
// Return type      : int : error code
// Argument         : int * conf_result: variable configure result
//                    CONF_ITEM * p_conf_item: configure item struct pointer
//----------------------------------------------------------------------------
int conf_parse_integer(void * conf_result, void * p_conf_item)
{
    CONF_ITEM * p_item;

    p_item = (CONF_ITEM *)p_conf_item;
    if ( (NULL != p_item->value) && ('0' <= *p_item->value) && (*p_item->value <= '9') )
    {
        *(int *)conf_result = atoi(p_item->value);
        return 0;
    }
    else
    {
        *(int *)conf_result = atoi(p_item->val_default);
        printf("\"%s\" use default value %s.\n",  p_item->name,  p_item->val_default);
        return 1;
    }
}

//----------------------------------------------------------------------------
// Function name    : conf_parse_string
// Description      : parse the string varialbe to string, equipped in CONF_ITEM
// Return type      : int : error code
// Argument         : char * conf_result: variable configure string
//                    CONF_ITEM * p_conf_item: configure item struct pointer
//----------------------------------------------------------------------------
int conf_parse_string(void * conf_result, void * p_conf_item)
{
    // add code here like conf_parse_integer
}
//----------------------------------------------------------------------------
// Function name    : conf_parse_ipaddr
// Description      : parse the string varialbe to ip address, equipped in CONF_ITEM
// Return type      : int : error code
// Argument         : char * conf_result: variable configure ip
//                    CONF_ITEM * p_conf_item: configure item struct pointer
//----------------------------------------------------------------------------
int conf_parse_ipaddr(void * conf_result, void * p_conf_item)
{
    // add code here like conf_parse_integer
}

//----------------------------------------------------------------------------
// Function name    : free_conf_value
// Description      : free the memory allocated in parse_conf_line
// DEPENDENCIES     : stdlib
// Return type      : int : error code
// Argument         : CONF_ITEM * p_conf_list: configure item struct list
//----------------------------------------------------------------------------
int free_conf_value(CONF_ITEM * p_conf_list)
{
    CONF_ITEM * p_item = NULL;

    for(p_item = p_conf_list; NULL != p_item->name; p_item++)
    {
        if ( NULL != p_item->value )
        {
            free(p_item->value);
            p_item->value = NULL;
        }
        else;
    }

    return 0;
}






//-----------------------------------main.c


#include <stdio.h>
#include "read_conf.h"


int main(int argc, char ** argv)
{
    /* �������б� */
    static CONF_ITEM conf_list[] = {
#ifdef __CONF_FIELD_SUPPORT__
      {"test", "result_max",     conf_integer, "19",         NULL, conf_parse_integer },
      {FIELD_ALL, "num_max",     conf_integer, "9",          NULL, conf_parse_integer },
      {FIELD_ALL, "start_num",   conf_integer, "1",          NULL, conf_parse_integer },
      {FIELD_ALL, "equ_num_max", conf_integer, "20",         NULL, conf_parse_integer },
//      {FIELD_ALL, "ipaddr",      conf_ipaddr, "192.168.1.1", NULL, conf_parse_ipaddr }, 
//      {FIELD_ALL, "host",        conf_string, "hxy",         NULL, conf_parse_string }, 
      {NULL, NULL,               conf_integer, 0,            NULL, NULL}, //������־
#else
      {"result_max",    conf_integer, "19",         NULL, conf_parse_integer },
      {"num_max",       conf_integer, "9",          NULL, conf_parse_integer },
      {"start_num",     conf_integer, "1",          NULL, conf_parse_integer },
      {"equ_num_max",   conf_integer, "20",         NULL, conf_parse_integer },
//      {"ipaddr",        conf_ipaddr, "192.168.1.1", NULL, conf_parse_ipaddr }, 
//      {"host",          conf_string, "hxy",         NULL, conf_parse_string }, 
      {NULL,            conf_integer, 0,            NULL, NULL}, //������־
#endif
    };
//    int  i;

    int result_max;
    int num_max;
    int start_num;
    int equ_num_max;
    char * conf_file_default = "cfg.ini";

    printf("\n");
    if ( 1 == argc )
    {
        printf("The default configure and output file is used. If want to use other file:\n");
        printf("usage : %s <conf_file> <out_file>\n\n", argv[0]);
        argv[1] = conf_file_default;
    }
    else;

    parse_conf_file(conf_list, argv[1]);
    conf_list[0].conf_handle(&result_max,     conf_list);
    conf_list[1].conf_handle(&num_max,        conf_list + 1);
    conf_list[2].conf_handle(&start_num,      conf_list + 2);
    conf_list[3].conf_handle(&equ_num_max,    conf_list + 3);
    free_conf_value(conf_list);

    getchar();
    return 0;
}
